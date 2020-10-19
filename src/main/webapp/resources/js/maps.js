var Polygon = ol.geom.Polygon;
var {createBox, createRegularPolygon} = ol.interaction.Draw;
var Draw = ol.interaction.Draw;
var Map = ol.Map; //import Map from 'ol/Map.js';
var View = ol.View; //import View from 'ol/View.js';
var {Tile, Vector} = ol.layer; //import {Tile as TileLayer, Vector as VectorLayer} from 'ol/layer.js';
var OSM = ol.source.OSM;
var Feature = ol.Feature; //import Feature from 'ol/Feature.js';
var Polyline = ol.format.Polyline; //import Polyline from 'ol/format/Polyline.js';
var Point = ol.geom.Point; //import Point from 'ol/geom/Point.js';
var TileLayer = Tile;
var VectorLayer = Vector;
var VectorSource = ol.source.Vector; //import VectorSource from 'ol/source/Vector.js';
var {Circle, Fill, Icon, Stroke, Style} = ol.style; //import {Circle as CircleStyle, Fill, Icon, Stroke, Style} from 'ol/style.js';

var raster = new TileLayer({
    source: new OSM(),
});

var source = new VectorSource({wrapX: false});

var styles = new ol.style.Style({
    stroke: new ol.style.Stroke({
        color: '#00FF00',
        width: 2
    }),
});

var vector = new ol.layer.Vector({
    source: source,
});

var map = new Map({
    layers: [raster, vector],
    target: 'map',
    view: new View({
        center: ol.proj.fromLonLat([9.469758, 55.936358]),
        zoom: 8
    }),
});

var typeSelect = document.getElementById('type');
var modal = document.getElementById("myModal");
var btnEdit = document.getElementById("editcolor");
var span = document.getElementsByClassName("close")[0];

let style = new ol.style.Style({
    stroke: new ol.style.Stroke({
        color: '#FF0000'
    }),
    text: new ol.style.Text({
        text: 'Text',
        stroke: new ol.style.Stroke({color: '#FF0000'})
    })
});

var draw; // global so we can remove it later
function addInteraction() {
    var value = typeSelect.value;
    if (value !== 'None') {
        var geometryFunction;
        if (value === 'Square') {
            value = 'Circle';
            geometryFunction = createRegularPolygon(4);
        } else if (value === 'Box') {
            value = 'Circle';
            geometryFunction = createBox();
        } else if (value === 'Star') {
            value = 'Circle';
            geometryFunction = function (coordinates, geometry) {
                var center = coordinates[0];
                var last = coordinates[1];
                var dx = center[0] - last[0];
                var dy = center[1] - last[1];
                var radius = Math.sqrt(dx * dx + dy * dy);
                var rotation = Math.atan2(dy, dx);
                var newCoordinates = [];
                var numPoints = 12;
                for (var i = 0; i < numPoints; ++i) {
                    var angle = rotation + (i * 2 * Math.PI) / numPoints;
                    var fraction = i % 2 === 0 ? 1 : 0.5;
                    var offsetX = radius * fraction * Math.cos(angle);
                    var offsetY = radius * fraction * Math.sin(angle);
                    newCoordinates.push([center[0] + offsetX, center[1] + offsetY]);
                }

                newCoordinates.push(newCoordinates[0].slice());
                if (!geometry) {
                    geometry = new Polygon([newCoordinates]);
                } else {
                    geometry.setCoordinates([newCoordinates]);
                }

                return geometry;
            };
        }

        draw = new Draw({
            source: source,
            type: value,
            geometryFunction: geometryFunction,
        });

        draw.on('drawend', function (e) {
            modal.style.display = "block";

            btnEdit.onclick = function () {
                var selectedcolor = document.getElementById("shapecolor").value;
                var shapeLabel = document.getElementById("shapelabel").value;

                style = new ol.style.Style({
                    stroke: new ol.style.Stroke({
                        color: selectedcolor,
                        width: 2
                    }),
                    text: new ol.style.Text({
                        text: shapeLabel,
                        stroke: new ol.style.Stroke({color: '#00BB00'})
                    })
                });


                modal.style.display = "none";
                e.feature.setStyle(style);
                e.feature.style_.geometry_ = typeSelect.value;
            }
        });


        map.addInteraction(draw);
    }
}

function loadFeatures() {
    $(function () {
        $.ajax({
            url: '/map/get_shapes',
            method: 'GET',
            contentType: 'application/json',
            success: function (response) {
                for (let shape of response) {
                    let shapeParsedCoordsData = JSON.parse(shape.coordinates);
                    let centerLongitudeLatitude = [shapeParsedCoordsData[1], shapeParsedCoordsData[2]];
                    let radius = shapeParsedCoordsData[0];
                    console.log(shape.color);
                    console.log(shape.label);
                    let layer = new ol.layer.Vector({
                        source: new ol.source.Vector({
                            features: [new ol.Feature(new ol.geom.Circle(centerLongitudeLatitude, radius))],
                        }),
                        style: new ol.style.Style({
                            stroke: new ol.style.Stroke({
                                color: shape.color,
                                width: 2
                            }),
                            text: new ol.style.Text({
                                text: shape.label,
                                stroke: new ol.style.Stroke({color: '#00BB00'})
                            })
                        })
                    });
                    map.addLayer(layer);
                }
            }
        });
    });
}

function saveFeatures() {
    for (let currentFeature of vector.getSource().getFeatures()) {
        let color = currentFeature.getStyle().getStroke().getColor();
        let label = currentFeature.getStyle().getText().getText();
        // let coordinates = currentFeature.values_.geometry.flatCoordinates;
        let coordinates = [];
        coordinates.push(currentFeature.getGeometry().getRadius());
        coordinates.push(currentFeature.getGeometry().getCenter());
        let geometryName = currentFeature.style_.geometry_;

        console.log('color ' + color);
        console.log('label ' + label);
        console.log('coordinates ' + coordinates[0]);
        console.log('coordinates ' + coordinates[1]);
        console.log('Geometry name ' + geometryName);
        // console.log(JSON.stringify(currentFeature, null, '    '));

        /*var circle = currentFeature.getGeometry().transform('EPSG:3857', 'EPSG:4326');
        console.log('radius:' + circle.getRadius());
        console.log('center:' + circle.getCenter());*/

        let shapeObject = {
            color: color,
            label: label,
            coordinates: coordinates.toString(),
            geometryName: geometryName
        }

        $(function () {
            $.ajax({
                url: '/map/save_shapes',
                method: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(shapeObject),
                success: function (response) {
                    console.log('Serialized and sent request OK');
                }
            });
        });
    }
}

document.getElementById("saveFeaturesList").addEventListener("click", saveFeatures);

/**
 * Handle change event.
 */
typeSelect.onchange = function () {
    map.removeInteraction(draw);
    addInteraction();
};

loadFeatures();
addInteraction();