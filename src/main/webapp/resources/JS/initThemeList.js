function log(message) {
    document.getElementById('log').innerHTML = message;
}

function getRest() {
    var xhr = new XMLHttpRequest();
    var body = document.getElementById("title").value;
    if (body == '') {
        alert('Пожалуйста, введи коректное значение для поиска');
        return false;
    } else {
        xhr.open("POST", '/getResult', true);
        xhr.setRequestHeader('Content-Type', 'text/plain');

        xhr.upload.onprogress = function (event) {
            log("Выполняется поиск. Пожалуйста подождите ...");
        }

        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                if (document.getElementById('res')) {
                    document.getElementById('res').remove();
                }
                var items = JSON.parse(xhr.responseText);
                if (items != null && items.items.length > 0) {
                    items = items.items;
                    var table = document.createElement("table");
                    table.id = 'res';
                    table.className = "table";
                    table.cellSpacing = 0;
                    var tr = document.createElement("tr");
                    tr.innerHTML = "<th>Date</th><th>Author</th><th>Title</th>";
                    table.appendChild(tr);
                    for (i = 0; i < items.length; i++) {
                        tr = document.createElement("tr");
                        if (items[i].answerCount > 0) {
                            tr.className = "answered"
                        }
                        var td = document.createElement("td");
                        td.innerHTML = items[i].creation_date;
                        tr.appendChild(td);
                        td = document.createElement("td");
                        td.innerHTML = items[i].name;
                        tr.appendChild(td);
                        td = document.createElement("td");
                        td.innerHTML =  "<a href='" + items[i].link + "' target='_blank'>" + items[i].title + "</a>";
                        tr.appendChild(td);
                        table.appendChild(tr);
                    }
                    result.appendChild(table);
                } else {
                    result.innerHTML = "<h3 id='res'>Ничего не найдено</h3>";
                }
                log(null);
            }
            else log("сервер временно не доступен")
        }
    }
    xhr.send(body);
}