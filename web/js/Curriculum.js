var source;

var assignmentElements = {title : "", text : "", id: "", published: ""};

function isbefore(a, b) {
    if (a.parentNode == b.parentNode) {
        for (var cur = a; cur; cur = cur.previousSibling) {
            if (cur === b) {
                return true;
            }
        }
    }
    return false;
}

function dragenter(e) {
    if (isbefore(source, e.target)) {
        e.target.parentNode.insertBefore(source, e.target);
    }
    else {
        e.target.parentNode.insertBefore(source, e.target.nextSibling);
    }
}

function dragstart(e) {
    source = e.target;
    e.dataTransfer.effectAllowed = 'move';
}

function addAssignment() {
    var ul = document.getElementById("assignmentList");
    var li = document.createElement("li");
    var a = document.createElement("a");
    var title = prompt("Enter the title of the assignment:");
    var text = prompt("Enter the description of the assignment:");
    var id = guid();
    var published = prompt("Would you like to publish the assignment? (y/n)");
    //while (published !== "y" || published !== "n"){
        //alert("The given answer was incorrect, please type y for yes or n for no.")
        //published = prompt("Would you like to publish the assignment? (y/n)");
    a.appendChild(document.createTextNode(title));
    a.setAttribute("href", "AssPage.html");
    li.appendChild(a);
    li.setAttribute("draggable", "true");
    li.setAttribute("ondragenter","dragenter(event)" );
    li.setAttribute("ondragstart", "dragstart(event)");
    ul.appendChild(li);
    assignmentElements.title = title;
    assignmentElements.text = text;
    assignmentElements.id = id;
    assignmentElements.published = published;
    $.ajax({
    url: "/AddTextPageServlet",
    data: (assignmentElements),
    type: "POST"
    });

}

function loadAssignments() {

    $(document).ready(function () {
        $.get("/AddTextPageServlet", function (data) {
            console.log("Data: " + data);
            console.log(data[0]);
            for (var i=0; i<data.length-1; i++){
                data[i].replace(",",":");
                var ul = document.getElementById("assignmentList");
                var li = document.createElement("li");
                var a = document.createElement("a");
                a.appendChild(document.createTextNode(data[i].title));
                a.setAttribute("href", "AssPage.html");
                li.appendChild(a);
                li.setAttribute("draggable", "true");
                li.setAttribute("ondragenter","dragenter(event)" );
                li.setAttribute("ondragstart", "dragstart(event)");
                ul.appendChild(li);
            }


        })
    })
}





        /*var parsedJSON = JSON.parse(jsonObject);

         var ul = document.getElementById("assignmentList");
         var li = document.createElement("li");
         var a = document.createElement("a");
         a.appendChild(document.createTextNode(i));
         a.setAttribute("href", "AssPage.html");
         li.appendChild(a);
         li.setAttribute("draggable", "true");
         li.setAttribute("ondragenter", "dragenter(event)");
         li.setAttribute("ondragstart", "dragstart(event)");
         ul.appendChild(li);*/


function guid() {
    function s4() {
        return Math.floor((1 + Math.random()) * 0x10000)
            .toString(16)
            .substring(1);
    }
    return s4() + s4() + '-' + s4() + '-' + s4() + '-' +
        s4() + '-' + s4() + s4() + s4();

}


