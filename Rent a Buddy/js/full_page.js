

let cuisine_holder = document.getElementById("cuisine_holder");
let remove_elements = [];


const credit_card = document.getElementById("credit");
const paypal = document.getElementById("paypal");
const gcash = document.getElementById("gcash");
const maya = document.getElementById("maya");

credit_card.addEventListener("change", () => {
    paypal.checked = false;
    gcash.checked = false;
    maya.checked = false;

});
paypal.addEventListener("change", () => {
    credit_card.checked = false;
    gcash.checked = false;
    maya.checked = false;

});
gcash.addEventListener("change", () => {
    credit_card.checked = false;
    paypal.checked = false;
    maya.checked = false;
   
});
maya.addEventListener("change", () => {
    credit_card.checked = false;
    paypal.checked = false;
    gcash.checked = false;

});



search_content();

function search_content() {
    
    find_content()
}


function find_content() {
    let userinput = localStorage.getItem("FullPageContent").toLowerCase()
    let kindoffood = localStorage.getItem("FoodKind").toLowerCase()
    let international_foods = [
    
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


    let filtered_result = international_foods.filter(cuisine =>cuisine.id.toLowerCase().includes(userinput))

    let suggestion = international_foods.filter(cuisine =>cuisine.kind.toLowerCase().includes(localStorage.getItem("FoodKind").toLowerCase()))


    // content codes
    filtered_result.forEach(food => {
        show_content(food,userinput)
    });


    // suggestion codes
    //mark for useless
    let main_holder = document.querySelector(".placeholder");
    
    remove_elements.forEach(Element => {
        Element.remove();
    })

    

}
function show_content(cuisine,input){
    let imgs = document.getElementById("img");
    let title = document.getElementById("title");
    let description = document.getElementById("description");
    let price = document.getElementById("price");


    imgs.src = cuisine.img_link;
    title.innerText = cuisine.food_name;
    description.innerText = cuisine.description;
    price.innerText = cuisine.food_price;
    


}





















