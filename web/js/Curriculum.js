var source;

var assignmentElements = {title : "", content : "", maxPoints : "", score: "", submissionRequirement: "",
    published: ""};

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

    var title = null;
    var content = null;
    var maxPoints = null;
    var score = null;
    var submissionRequirement = null;
    var published = null;
    assignmentElements.title = title;
    assignmentElements.content = content;
    assignmentElements.maxPoints = maxPoints;
    assignmentElements.score = score;
    assignmentElements.submissionRequirement = submissionRequirement;
    assignmentElements.published = published;
    var obj = JSON.stringify(assignmentElements);
    $.ajax({
    url: "/AddTextPageServlet",
    data: obj,
    type: "POST"
    });

}

function loadAssignments() {

    $(document).ready(function () {
        $.get("/AddTextPageServlet", function (data) {

            var x = JSON.parse(data);
            console.log("Data: " + x.title);
            console.log("Data: " + x.text);
            console.log("Data: " + x.id);
            console.log("Data: " + x.published);

            /*
            var x = data.substring(1,data.length).split(",",4);
            for (var i=0; i<x.length; i++){
                var ul = document.getElementById("assignmentList");
                var li = document.createElement("li");
                var a = document.createElement("a");
                console.log(x[0]);
                a.appendChild(document.createTextNode(x[0].substring(x[0].indexOf("=")+1)));
                a.setAttribute("href", "AssPage.html");
                li.appendChild(a);
                li.setAttribute("draggable", "true");
                li.setAttribute("ondragenter","dragenter(event)" );
                li.setAttribute("ondragstart", "dragstart(event)");
                ul.appendChild(li);
            }
            */

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


