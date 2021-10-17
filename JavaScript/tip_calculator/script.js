
    const amount = document.getElementById('amount');
    const service = document.getElementById('service');
    const people = document.getElementById('people');

    var tip = document.getElementById('tip');

    document.getElementById('btn').addEventListener('click', function(){
        let totaltip = amount.value * service.value;
        if(service.value == ""){
            alert("Please select service");
        }

        else{
            tip.innerHTML = `Tip is ₹ ${Math.round(totaltip/people.value)} Each`
        }
    }
    )

