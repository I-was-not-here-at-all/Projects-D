//Code to Display  the gantt chart

//9/14/2026 task:
//code and display the gantt chart without calculations.[0/6]
//status: INCOMPLETE

let chart_holder = document.getElementById("chartHolder");
//arrays



let First_Process = true;
//functions
//main
function Solve(){
    chart_holder.innerHTML = "";
    let BurstTime = document.getElementById("BurstTimes").value + " ";
    let ArrivalTime = document.getElementById("ArrivalTimes").value + " ";
    let ArrivalTimes = [];
    let BurstTimes = [];
    
    

    let arrivalTimeValue = "";
    let burstTimeValue = "";
    //code for getting the data from input
    for(let i = 0; i != BurstTime.length;i++){
        //code to make sure that it will take the value per spaces " "
        if(BurstTime.charAt(i) !== " "){
                //checks whether arrival time value is empty if empty set the current character as its value
            if(arrivalTimeValue == "" && burstTimeValue ==""){
                arrivalTimeValue = ArrivalTime.charAt(i)
                burstTimeValue = BurstTime.charAt(i)
            }else {
                arrivalTimeValue = arrivalTimeValue + ArrivalTime.charAt(i)
                burstTimeValue = burstTimeValue + BurstTime.charAt(i)
            }
            
           
        }else {
            //pushes the value it get after the system detects " " while also converting it to integer
            ArrivalTimes.push(Math.floor(+arrivalTimeValue));
            BurstTimes.push(Math.floor(+burstTimeValue));
            //resets arrival time value after pushing it to prevent data inconsistency
            arrivalTimeValue = "";
            burstTimeValue = "";
        }  
    }

    let process = [BurstTimes, ArrivalTimes];

    switch (algorithm.value){
        case "FCFS":
            
            FCFS(process);
            break;
        case "PREEMPTIVE":
            
            break;
    }
    //resets everything to repeat the cycle
    ArrivalTimes = [];
    BurstTimes = [];
    process = [];
    First_Process = true;
}



//sub
function FCFS(process){
//do something


// arrivaltime.forEach(arrival => {

//     for(let i = 0; i != arrivaltime.lenght; i++
//     ){

//         if(arrivaltime < arrivaltime[i] ){
//             newArrival.push(arrivaltime);
            
//         }
//     }
    
    
// });
let newProcess = sort2DArrayByColumn(process, 0);

console.log("This is new Process" + newProcess);
    
    
    
//do process for each arrival time
//sorter of arrival time




let burstime = newProcess[0];

let arrivaltime = newProcess[1];

let processCount = 0;
let burst = 0;
let totalBurst = 0;

//display code. mark for changes
arrivaltime.forEach(arrival => {
    processCount++;
    displayProcessBlock(processCount,totalBurst +burstime[burst]);
    totalBurst = totalBurst + burstime[burst];
    burst++;
});

}



function SJF(){
    
}
function SRTF(){
    
}
function RR(){
    //local variables for the extra input

}
function PREEMPTIVE(){
    
}
function NONPREEMPTIVE(){
    
}

//display function

function displayProcessBlock(CurrentProcess,ProcessBlockUsed){
    let process_block = document.createElement("div");
    let process = document.createElement("p");
    let after = document.createElement("p");

    process_block.classList.add("process_block");
    process.textContent = "P" + CurrentProcess;
    process.id = "process";
    after.textContent = ProcessBlockUsed;
    after.id = "after";

    if(First_Process){
        let before = document.createElement("p");
        before.textContent = "0";
        before.id = "before";
        process_block.appendChild(before);
        First_Process = false;
    }

    //append
    process_block.appendChild(process);
    process_block.appendChild(after);

    process_block.cloneNode(true);

    chart_holder.append(process_block);



}


//sorter from AI sorts arrival time by also moving its column
function sort2DArrayByColumn(matrix, columnIndex) {
    let n = matrix.length;
    // Shallow copy to avoid mutating the original array directly
    let arr = [...matrix]; 

    for (let i = 0; i < n - 1; i++) {
        for (let j = 0; j < n - i - 1; j++) {
            // Compare the elements at the specified column index
            if (arr[j][columnIndex] > arr[j + 1][columnIndex]) {
                // Swap the entire row elements
                let temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    return arr;
}