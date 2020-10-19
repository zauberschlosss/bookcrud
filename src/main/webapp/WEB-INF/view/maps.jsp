<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>Draw Shapes</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.4.3/css/ol.css" type="text/css">
    <link rel="stylesheet" href="/resources/ol/ol.css" type="text/css">
    <script src="/resources/js/jquery-3.5.1.js"></script>
    <style>
        .map {
            width: 100%;
            height:80%;
        }
        .button1 {
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            background-color: #008CBA;
        }
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }

        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 20%; /* Could be more or less, depending on screen size */
        }

        /* The Close Button */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div id="map" class="map"></div>
<br>
<form class="form-inline">
    <label>Shape type &nbsp;</label>
    <select id="type">
        <option value="Circle">Circle</option>
        <option value="Square">Square</option>
        <option value="Box">Box</option>
        <option value="Star">Star</option>
        <option value="None">None</option>
    </select>
</form>
<div id="myModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <p><b>Shape label and color</b></p>
        <label for="shapelabel">Shape label</label>
        <input type="text" id="shapelabel" name="shapelabel">
        <br>
        <br>
        <input type="color" id="shapecolor">
        <br>
        <br>
        <button class="button1" id="editcolor">Ok</button>
    </div>

</div>
<button class="button1" id="saveFeaturesList">Save</button>

<script src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.4.3/build/ol.js"></script>
<script src="/resources/js/maps.js" type="module"></script>
</body>
</html>