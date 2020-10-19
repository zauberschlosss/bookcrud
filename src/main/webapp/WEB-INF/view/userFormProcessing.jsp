<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bookstorage.bookdemo.model.UserModel" %>
<%@ page import="com.bookstorage.bookdemo.entity.UserEntity" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Created User Data</title>

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/jq-3.3.1/dt-1.10.22/b-1.6.5/b-colvis-1.6.5/sl-1.3.1/datatables.min.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/jq-3.3.1/dt-1.10.22/b-1.6.5/b-colvis-1.6.5/sl-1.3.1/datatables.min.js"></script>

</head>
<body>
<h3>Parameter values:</h3>

<table id="users-table" class="display" style="width: 100%">

</table>

<script>
    $(function () {
        $.ajax({
            url: '/users/get_users',
            method: 'GET',
            success: function(response) {
                $("#users-table").dataTable({
                    data: response,

                    columnDefs: [
                        {
                            orderable: false,
                            targets: 0,
                            className: 'select-checkbox',
                        }
                    ],
                    select: {
                        style: 'multi',
                        items: 'row'
                    },
                    order: [[1, 'asc']],

                    columns: [
                        {
                            data: null,
                            defaultContent: ''
                        },
                        {
                            data: "id",
                            title: "id"
                        },
                        {
                            data: "email",
                            title: "email"
                        },
                        {
                            data: "username",
                            title: "username"
                        }
                    ],

                    dom: 'Bfrtip',
                    buttons: [
                        {
                            text: 'Delete',
                            action: function ( e, dt, button, config ) {
                                let data = dt.rows( { selected: true} ).data();
                                let usersId = [];

                                for (let i = 0; i < data.length; i++) {
                                    usersId.push(data[i].id);
                                }

                                $.ajax({
                                    url: '/users/delete_users',
                                    method: 'POST',
                                    data: {'userIds': usersId.toString()},
                                    success: function () {
                                        dt.rows('.selected').remove().draw();
                                    }
                                })
                            }
                        }
                    ]
                });
            },
            error: function(response) {

            }
        });
    });
</script>

</body>
</html>