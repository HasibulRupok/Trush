function allowDrop(ev) {
    ev.preventDefault();
}

function dragStart(ev) {
    ev.dataTransfer.setData("text", ev.target.id);

    // console.log(ev.target.id);
}

function dragDrop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    ev.target.append(document.getElementById(data));
    isConfilcked(ev.target.id);
}

function isConfilcked(td_id){
    const td = document.getElementById(td_id);
    const childs = td.childNodes;
    
    const innerText  = [];
    childs.forEach(child => {
        innerText.push(child.innerText);
    });

    const flag = findDuplicates(innerText);
    if(flag.length){
        console.log("** error detected **");
    }
}

let findDuplicates = arr => arr.filter((item, index) => arr.indexOf(item) != index)
