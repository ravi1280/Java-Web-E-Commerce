
async  function signUp() {
    const  user_dto = {
        fName: document.getElementById("fName").value,
        lName: document.getElementById("lName").value,
        mobile: document.getElementById("mobile").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
    }
    console.log(user_dto);

    const  response = await fetch(
            "SignUp",
            {
                method: "POST",
                body: JSON.stringify(user_dto),
                heders: {
                    "Content-Type": "application/json"
                }

            }
    );
    if(response.ok){
        const json = await  response.json();
        console.log(json.success);
        console.log(json.content);
    }else{
        console.log("Error");
    }
}

