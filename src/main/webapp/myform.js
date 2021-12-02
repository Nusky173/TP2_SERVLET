const select = document.querySelector('select');

select.addEventListener('change', setUserType);

function setUserType() {
    const choice = select.value;
    if (choice === 'individual') {
        document.getElementById('tel-individual').type = "text"

        document.getElementById('professional').remove();
    } else if (choice === 'professional'){
        document.getElementById('agenda-url').type = "text"
        document.getElementById('agenda-login').type = "text"
        document.getElementById('agenda-password').type = "text"

        document.getElementById('individual').remove();

    }

    function hiddenValue(name){
        var hvalue = "some_value";
        document.createElement("input").innerHTML =
            '<input type="text" value="' + hvalue + '" name="'+ name +'"/>';

        doSomething();
    }

    function doSomething(hvalue = ''){
        //do in here
    }
}