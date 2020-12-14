

// Logic for both fields
// [6] Alter Reimbursment Amount
// [8] Exceeding Available Funds



function eventFunction(){
    


    let alteReimbursmentAmount = document.getElementById('i_alteReimbursmentAmount').value;
    let final_alteReimbursmentAmount = document.getElementById('f_alteReimbursmentAmount').value;

    if(alteReimbursmentAmount > 1000){
    	document.getElementById('i_exceedingAvailableFunds').value = 'yes';
         document.getElementById('i_exceedingAvailableFunds').style.color = "red"; 
         
    }
    else{
    		document.getElementById('i_exceedingAvailableFunds').value = 'no';
            document.getElementById('i_exceedingAvailableFunds').style.color = "black"; 
    }
    
    document.getElementById('i_pendingAmountVal').value = alteReimbursmentAmount;
    document.getElementById('i_alteReimbursmentAmount').value = alteReimbursmentAmount;
    document.getElementById('i_finalReimburseValBenco').value = alteReimbursmentAmount;

    document.getElementById('f_alteReimbursmentAmount').value = final_alteReimbursmentAmount;
    document.getElementById('f_finalReimburseValBenco').value = final_alteReimbursmentAmount;
    


}