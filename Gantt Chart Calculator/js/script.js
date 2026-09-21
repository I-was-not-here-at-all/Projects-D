//code to display the inputs
//ps: This was supposed to be a global script but i used it for inputs lol.

let algorithm = document.getElementById("algorithmSelect");
let inputHolder = document.getElementById("inputHolder");

changeContent(algorithm);
//9/14/2026 task:
//create the code for displaying the inputs based on the given algorithm.[Completed]- 11:01 am (9/14/26)
//status: COMPLETE

//Events Listeners
algorithm.addEventListener('change', ()=> {
    changeContent(algorithm); //uses function so that the content will display at the start
});

//functions
function changeContent(algorithm){
    console.log(algorithm.value);
    inputHolder.innerHTML = ''; //removes child of input holder class at the start so that there are no duplicates
    //displays default inputs of algorithms
    display_inputs("ArrivalTimes", "Arrival Times:","e.g. 0 1 2 3 4 5"); 
    display_inputs("BurstTimes", "Burst Times:","e.g. 0 1 2 3 4 5");
    //adds another input when the value is the following:
    switch (algorithm.value) {
        case "RR":
            display_inputs("TimeQuantum", "Time Quantum: ","e.g. 1");
            break;
        case "PREEMPTIVE":
            display_inputs("Priorities", "Priorities: ","e.g. Lower # = Higher Priority");
            break;
    }
}

function display_inputs(id, inputTitle, placeholder) {
    //variables
    let algorithm_div = document.createElement("div");
    let label = document.createElement("label");
    let p = document.createElement("p");
    let inputs = document.createElement("input");

    //appends child to respective parent
    algorithm_div.classList.add("Algorithm_Group");
    p.textContent = inputTitle;
    label.appendChild(p);
    algorithm_div.appendChild(label) 
    inputs.id = id;
    inputs.type = "search";
    inputs.placeholder = placeholder;
    algorithm_div.appendChild(inputs);

    //displays
    let input = algorithm_div.cloneNode(true);
    inputHolder.append(input);

}




