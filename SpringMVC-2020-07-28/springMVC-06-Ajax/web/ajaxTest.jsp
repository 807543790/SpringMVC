<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="static/js/jquery-3.5.1.js"></script>
    <script>
        window.onload = function () {
            $("#btn").click(
                function () {
                    $.post({
                        url:"/a2",
                        success:function (data) {

                            console.log(data);

                            var html ="";

                            for(let i=0;i<data.length;i++){
                                html += "<tr>" +
                                        "<td>" + data[i].id + "</td>"+
                                         "<td>" + data[i].name +"</td>"+
                                         "<td>" + data[i].age + "</td>"+
                                    "</tr>"
                            }

                            $("#Trtest").html(html)
                        }
                    })
                }
            )
        }
    </script>
</head>
<body>
    <input type="button" value="获取数据" id="btn">
    <table>
        <tr>
            <td>id</td>
            <td>名称</td>
            <td>年龄</td>
        </tr>
        <tbody id="Trtest">

        </tbody>
    </table>
</body>
</html>
