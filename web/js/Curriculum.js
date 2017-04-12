var source;

var assignmentElements = {Assignments : [], Text : []};

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
    var assignment = prompt("Enter the title of the assignment:");
    var text = prompt("Enter the description of the assignment:")
    a.appendChild(document.createTextNode(assignment));
    a.setAttribute("href", "AssPage.html");
    li.appendChild(a);
    li.setAttribute("draggable", "true");
    li.setAttribute("ondragenter","dragenter(event)" );
    li.setAttribute("ondragstart", "dragstart(event)");
    ul.appendChild(li);
    assignmentElements.Assignments = assignment;
    assignmentElements.Text = text;
    $.ajax({
    url: "/AddTextPageServlet",
    data: JSON.stringify(assignmentElements),
    type: "POST"

    });

}


function loadAssignments() {

   function (data) {
       data[i].title
       data[i].text

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



}


