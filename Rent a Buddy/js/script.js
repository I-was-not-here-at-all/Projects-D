let content_of_full_page;
let kind_of_food;
let jap_or_kor;
let category
function get_data() {
    let user_input = document.getElementById("user_input").value;
    localStorage.setItem("UserInput",user_input);
    location.href = "searchpage.html";
 }
 
 document.querySelector('input').addEventListener('keypress', function(event) {
     if (event.key === 'Enter') {
         event.preventDefault(); 
         get_data()
         document.querySelector('button').click();
     }
 });

//  document.querySelector(".full_page_link").addEventListener("click", () => {

//     localStorage.setItem("FullPageContent",content_of_full_page);
//     location.href = "Full_Detailed_Page.html";
// })

function dothis(){
        localStorage.setItem("FullPageContent",content_of_full_page);
        localStorage.setItem("FoodKind",kind_of_food);

        location.href = "Full_Detailed_Page.html";
}

function chosen_content() {
    localStorage.setItem("JapOrKor",jap_or_kor);
}

function choose_category() {
    localStorage.setItem("ChosenCategory",category);
    location.href = "searchpage.html";

}
// function get_data() {
//     let user_input = document.getElementById("user_input").value.toLowerCase();
//     localStorage.setItem("UserInput",user_input);
//     location.href = "searchpage.html";
//  }
 

// document.querySelector('#user_input').addEventListener('keyup', function(event) {
//     if (event.key === 'Enter') {
//         event.preventDefault(); 
//         let user_input = document.getElementById("user_input").value.toLowerCase();
//         localStorage.setItem("UserInput",user_input);
//         location.href = "searchpage.html";
//         get_data();
//         document.querySelector('.search_button').click();
//     }
// });

