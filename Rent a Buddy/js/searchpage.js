// elem.setAttribute("onclick","content_of_full_page = 'makizushi';dothis();"); - the code for adding attibute in javascrip using jquery

document.getElementById("user_input").value = localStorage.getItem("UserInput");

let cuisine_holder = document.getElementById("cuisine_holder");
let remove_elements = [];
let content_of_full_page;

let japanese_korean_cuisines = [
    
    {
        "food_name":"Toska Emirose",
        "food_type":"European",
        "food_price": "₱5,000.00",
        "cost": 5000.00, 
        "country": "Male", 
        "meal_type": "European",
        "description": "A friend or a foe? It doesn't really matter! Come, sit down, and enjoy the show ~", //description of the person
        "img_link": "assets/images/People/European1.png",
        "full_page": "javascript:content_of_full_page = 'toska';kind_of_food = 'sashimi';dothis();",
        "id": "toska",
        "kind": "sashimi"
    },
    {
        "food_name":"Varis Sage",
        "food_type":"Asian",
        "food_price": "₱10,000.00",
        "cost": 10000.00,  
        "country": "Male", 
        "meal_type": "Asian",
        "description": "I am a Neurosurgeon at Oriniore Hospital. I'm busy. Only purchase my services should you have the money and noting else better to do.", //description of the person
        "img_link": "assets/images/People/Asian1.png",
        "full_page": "javascript:content_of_full_page = 'varis';kind_of_food = 'sashimi';dothis();",
        "id": "varis",
        "kind": "sashimi"
    },
    {
        "food_name":"Sirius Bridgerton",
        "food_type":"European", 
        "food_price": "₱2,500.00", 
        "cost": 2500.00, 
        "country": "Male", 
        "meal_type": "European", 
        "description": "Just a humble traveler! I don't really know what this site is...why do you need to pay to talk to people?",
        "img_link": "assets/images/People/European2.jpg",
        "full_page": "javascript:content_of_full_page = 'sirius';kind_of_food = 'sashimi';dothis();",
        "id": "sirius",
        "kind": "sashimi"
    },
    {
        "food_name":"Will Stetson",
        "food_type":"European3.png", 
        "food_price": "₱50,000.00",
        "cost": 50000.00, 
        "country": "Male",
        "meal_type": "European", 
        "description": "₱ 50,000 for not only a friend for a day, but also your darling tarot reader as well! Ask me anything, I am at your service <3",
        "img_link": "assets/images/People/European3.png",
        "full_page": "javascript:content_of_full_page = 'will';kind_of_food = 'sashimi';dothis();",
        "id": "will",
        "kind": "sashimi"
    },
    {
        "food_name":"Valentine Lovelace",
        "food_type":"American", 
        "food_price": "₱5,000.00", 
        "cost": 5000.00, 
        "country": "Male", 
        "meal_type": "American", 
        "description": "If you know me, no you don't! Valentine Lovelace, at your dearest command. Feel free to hire, should there be any suspicious activity around—ESPECIALLY if there's suspicious activity around. I'll come as a detective and your friend, of course.",
        "img_link": "assets/images/People/American1.png",
        "full_page": "javascript:content_of_full_page = 'lovelace';kind_of_food = 'sashimi';dothis();",
        "id": "lovelace",
        "kind": "sashimi"
    },
    {
        "food_name":"Hael Langit",
        "food_type":"Filipino", 
        "food_price": "₱2500.00", 
        "cost": 2500.00,  
        "country": "Male",
        "meal_type": "Filipino",
        "description": "Licensed photographer. Hire for services...or a buddy, I guess.",
        "img_link": "assets/images/People/Filipino1.png",
        "full_page": "javascript:content_of_full_page = 'hael';kind_of_food = 'sashimi';dothis();",
        "id": "hael",
        "kind": "sashimi"
    },
    {
        "food_name":"Luna Solace",
        "food_type":"Asian",
        "food_price": "₱2,500.00", 
        "cost": 2500.00,
        "country": "Female", //Gender male Female or LGBTQ
        "meal_type": "Asian",
        "description": "Haiii!!! I'm Luna ｡⁠◕⁠‿⁠◕⁠｡ or you can call me anything, really!! I'm just a girl <3 looking for friends!!!",
        "img_link": "assets/images/People/Filpinogirl2.jpg",
        "full_page": "javascript:content_of_full_page = 'luna';kind_of_food = 'sashimi';dothis();",
        "id": "luna",
        "kind": "sashimi"
    },
    {
        "food_name":"Star Santos",
        "food_type":"Filipino", 
        "food_price": "₱2,500.00", 
        "cost": 2500.00,  
        "country": "LGBTQ",
        "meal_type": "Filipino", 
        "description": "I was forced against my will to sign up in this app. Pray I don't get doxxed gng 🙏",
        "img_link": "assets/images/People/LGBTFil1.png",
        "full_page": "javascript:content_of_full_page = 'star';kind_of_food = 'sashimi';dothis();",
        "id": "star",
        "kind": "sashimi"
    },
    {
        "food_name":"Bassiey Bloomington",
        "food_type":"Black", 
        "food_price": "₱3,000.00", 
        "cost": 3000.00,  
        "country": "Female", 
        "meal_type": "Black", 
        "description": "Just a girl trying to get through life okay ^^,,, I hope we can be friends!!!",
        "img_link": "assets/images/People/Blackgirl1.png",
        "full_page": "javascript:content_of_full_page = 'bloomington';kind_of_food = 'sashimi';dothis();",
        "id": "bloomington",
        "kind": "sashimi"
    },
    {
        "food_name":"Novastella Novelite",
        "food_type":"Black", 
        "food_price": "₱7,000.00", 
        "cost": 7000.00,  
        "country": "LGBTQ", 
        "meal_type": "Black",
        "description": "“If a cluttered desk is a sign of a cluttered mind, of what, then, is an empty desk a sign?” – Albert Einstein. I think we can all strive to be decent human beings. Give me a chat if you ever feel down, I'll lend an ear.", 
        "img_link": "assets/images/People/LGBTBlack.png",
        "full_page": "javascript:content_of_full_page = 'novelite';kind_of_food = 'sashimi';dothis();",
        "id": "novelite",
        "kind": "sashimi"
    },
    {
        "food_name":"Virgil Venture",
        "food_type":"Australian", 
        "food_price": "₱6,500.00", 
        "cost": 6500.00, 
        "country": "Male", 
        "meal_type": "Australian", 
        "description": "A humble manager of UniTea Cafe! Feel free to come chat, I've gone bored of my abundance of paper work, haha.",
        "img_link": "assets/images/People/Australian.png",
        "full_page": "javascript:content_of_full_page = 'virgil';kind_of_food = 'sashimi';dothis();",
        "id": "virgil",
        "kind": "sashimi"
    },
    {
        "food_name":"Mae Santos",
        "food_type":"Filipino", 
        "food_price": "₱6,200.00", 
        "cost": 6200.00, 
        "country": "Female", 
        "meal_type": "Filipino", 
        "description": "A humble Student from the Philippines. Studying Ergonomics",
        "img_link": "assets/images/People/Filipinogirl1.png",
        "full_page": "javascript:content_of_full_page = 'mae';kind_of_food = 'sashimi';dothis();",
        "id": "mae",
        "kind": "sashimi"
    }

];





// checkboxes variables

// sort
let japanese = document.getElementById("japanese");
let korean = document.getElementById("korean");
let cheap_expens = document.getElementById("cheap_expensive");
let expens_cheap = document.getElementById("expensive_cheap");
let chosen_data = localStorage.getItem("JapOrKor");
let chosen_category = localStorage.getItem("ChosenCategory");




// filter

let meal = document.getElementById("meal");
let desserts = document.getElementById("desserts");
let pastries = document.getElementById("pastries");
let breakfast = document.getElementById("breakfast");
let lunch = document.getElementById("lunch");
let dinner = document.getElementById("dinner");

function reset_filter() {
    meal.checked = false;
    desserts.checked = false;
    pastries.checked = false;
    breakfast.checked = false;
    lunch.checked = false;
    dinner.checked = false;
    japanese.checked = false;
    korean.checked = false;
    cheap_expens.checked = false;
    expens_cheap.checked = false;
    document.getElementById("user_input").value = "";
    find_content()


}

meal.addEventListener("change", () => {
    desserts.checked = false;
    pastries.checked = false;
    breakfast.checked = false;
    lunch.checked = false;
    dinner.checked = false;
    find_content();


});
desserts.addEventListener("change", () => {
    meal.checked = false;
    pastries.checked = false;
    breakfast.checked = false;
    lunch.checked = false;
    dinner.checked = false;
    find_content();


});
pastries.addEventListener("change", () => {
    meal.checked = false;
    desserts.checked = false;
    breakfast.checked = false;
    lunch.checked = false;
    dinner.checked = false;
    find_content();


});
breakfast.addEventListener("change", () => {
    meal.checked = false;
    desserts.checked = false;
    pastries.checked = false;
    lunch.checked = false;
    dinner.checked = false;
    find_content();


});
lunch.addEventListener("change", () => {
    meal.checked = false;
    desserts.checked = false;
    pastries.checked = false;
    breakfast.checked = false;
    dinner.checked = false;
    find_content();


});
dinner.addEventListener("change", () => {
    meal.checked = false;
    desserts.checked = false;
    pastries.checked = false;
    breakfast.checked = false;
    lunch.checked = false;
    find_content();


});

// end
// sort system code

japanese.addEventListener("change", () => {
    korean.checked = false;
    cheap_expens.checked = false;
    expens_cheap.checked = false;
    // sorted_data = japanese_korean_cuisines.filter(cuisine => cuisine.country.includes("Japanese"));
    find_content();

});
korean.addEventListener("change", () => {
    japanese.checked = false;
    cheap_expens.checked = false;
    expens_cheap.checked = false;
    // sorted_data = japanese_korean_cuisines.filter(cuisine => cuisine.country.includes("Korean"));
    find_content();
});
cheap_expens.addEventListener("change", () => {
    japanese.checked = false;
    korean.checked = false;
    expens_cheap.checked = false;
    find_content();

});
expens_cheap.addEventListener("change", () => {
    japanese.checked = false;
    korean.checked = false;
    cheap_expens.checked = false;
    find_content();

});

//Mark as Useless
if (chosen_data == "japanese") {
    japanese.checked = true;
    localStorage.removeItem("JapOrKor")
} else if (chosen_data == "korean") {
    korean.checked = true;
    localStorage.removeItem("JapOrKor")
}

if (chosen_category == "japanese_meal") {
    japanese.checked = true;
    meal.checked = true;
    localStorage.removeItem("ChosenCategory");
}else if(chosen_category == "japanese_desserts") {
    japanese.checked = true;
    desserts.checked = true;
    localStorage.removeItem("ChosenCategory");
}else if(chosen_category == "japanese_pastries") {
    japanese.checked = true;
    pastries.checked = true;
    localStorage.removeItem("ChosenCategory");
}else if(chosen_category == "korean_meal") {
    korean.checked = true;
    meal.checked = true;
    localStorage.removeItem("ChosenCategory");
}else if(chosen_category == "korean_desserts") {
    korean.checked = true;
    desserts.checked = true;
    localStorage.removeItem("ChosenCategory");
}else if(chosen_category == "korean_pastries") {
    korean.checked = true;
    pastries.checked = true;
    localStorage.removeItem("ChosenCategory");
}


find_content();

document.querySelector('#user_input').addEventListener('keypress', function (event) {
    if (event.key === 'Enter') {
        event.preventDefault();
        find_content();
        document.querySelector('button').click();
    }
});




function find_content() {



    let search_bar = document.getElementById("user_input");
    let user_input = search_bar.value;


    document.getElementById("searched_text").innerText = user_input;
    let user_searched = user_input.toLowerCase();

    let filtered_result = japanese_korean_cuisines.filter(japanese_korean_cuisines => japanese_korean_cuisines.food_name.toLowerCase().includes(user_searched));

    let main_holder = document.querySelector(".placeholder");

    if (korean.checked == true) {
        filtered_result = filtered_result.filter(cuisines => cuisines.country.includes("Male"));
        filtered_result.forEach(cuisines => {
            check_content(filtered_result);
        });

    } else if (japanese.checked == true) {
        filtered_result = filtered_result.filter(cuisines => cuisines.country.includes("Female"));
        filtered_result.forEach(cuisines => {
            check_content(filtered_result);
        });
    } else if (cheap_expens.checked == true) {
        filtered_result = filtered_result.filter(cuisines => cuisines.country.includes("LGBTQ"));
        filtered_result.forEach(cuisines => {
            check_content(filtered_result);
        });
    } else if (expens_cheap.checked == true) {
        filtered_result = filtered_result.sort(function (a, b) { return a.cost - b.cost });
        filtered_result.forEach(cuisines => {
            check_content(filtered_result);
        });
    } else {
        
        filtered_result.forEach(cuisines => {
            check_content(filtered_result);
        });
    }

    function check_content(foods) {


        if(meal.checked == true){
            foods = foods.filter(cuisine => cuisine.food_type.includes("Asian"));
            remove_elements.forEach(Element => {
                Element.remove();
            })
    
            foods.forEach(cuisines => {
                display_content(cuisines, main_holder);
    
            });
        }else if(desserts.checked == true){
            foods = foods.filter(cuisine => cuisine.food_type.includes("Filipino"));
            remove_elements.forEach(Element => {
                Element.remove();
            })
    
            foods.forEach(cuisines => {
                display_content(cuisines, main_holder);
    
            });
        }else if(pastries.checked == true){
            foods = foods.filter(cuisine => cuisine.food_type.includes("American"));
            remove_elements.forEach(Element => {
                Element.remove();
            })
    
            foods.forEach(cuisines => {
                display_content(cuisines, main_holder);
    
            });
        }else if(breakfast.checked == true){
            foods = foods.filter(cuisine => cuisine.meal_type.includes("European"));
            remove_elements.forEach(Element => {
                Element.remove();
            })
    
            foods.forEach(cuisines => {
                display_content(cuisines, main_holder);
    
            });
        }else if(lunch.checked == true){
            foods = foods.filter(cuisine => cuisine.meal_type.includes("Australian"));
            remove_elements.forEach(Element => {
                Element.remove();
            })
    
            foods.forEach(cuisines => {
                display_content(cuisines, main_holder);
    
            });
        }else if(dinner.checked == true){
            foods = foods.filter(cuisine => cuisine.meal_type.includes("Black"));
            remove_elements.forEach(Element => {
                Element.remove();
            })
    
            foods.forEach(cuisines => {
                display_content(cuisines, main_holder);
    
            });
        }else{
            remove_elements.forEach(Element => {
                Element.remove();
            })
    
            foods.forEach(cuisines => {
                display_content(cuisines, main_holder);
    
            });
        }

        
    }









    search_bar.value = "";
    text_result(filtered_result)
    localStorage.removeItem("UserInput");
}

// System for making content
function display_content(cuisine, content) {


    let card_holder = document.createElement("div");
    let link = document.createElement("a");
    let content_holder = document.createElement("div");
    let img_holder = document.createElement("div");
    let img = document.createElement("img");
    let title_context_holder = document.createElement("div");
    let title = document.createElement("h3");
    let price = document.createElement("p");

    // displaying content

    card_holder.classList.add("card_holder", "mt-3", "col-md-4");

    link.setAttribute("onclick", cuisine.full_page);
    link.classList.add("full_page_link")
    card_holder.appendChild(link);

    content_holder.classList.add("content_holder");
    link.href = "#"
    link.appendChild(content_holder);

    img_holder.classList.add("img_holder");
    content_holder.appendChild(img_holder);

    img.src = cuisine.img_link;

    img_holder.appendChild(img);

    title_context_holder.classList.add("title_holder_and_Context_holder");
    title.classList.add("mb-4");
    title.textContent = cuisine.food_name;
    title_context_holder.appendChild(title);
    price.textContent = cuisine.food_price;
    title_context_holder.appendChild(price);

    content_holder.appendChild(title_context_holder);
    let copy_holder = card_holder.cloneNode(true);
    // cuisine_holder.appendChild(card_holder);
    cuisine_holder.append(copy_holder);
    remove_elements.push(copy_holder);
}






// the code when changing to full page


// document.querySelector(".full_page_link").addEventListener("click", () => {

//     localStorage.setItem("FullPageContent",content_of_full_page);
//     location.href = "Full_Detailed_Page.html";
// })

function dothis() {
    localStorage.setItem("FullPageContent", content_of_full_page);
    localStorage.setItem("FoodKind", kind_of_food);
    location.href = "Full_Detailed_Page.html";
}


function text_result(filtered_result) {
    let result_data = filtered_result.length;
    let text = document.getElementById("end_text");
    if (result_data <= 0) {
        text.innerText = "Sorry, no results were found:(";
    } else {
        text.innerText = "End of content.";
    }
}
