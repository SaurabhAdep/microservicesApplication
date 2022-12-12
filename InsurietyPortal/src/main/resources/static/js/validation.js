function validateForm() {
    var firstName = document.consumerBusiness.firstName.value;
    var lastName = document.consumerBusiness.lastName.value;
    var dob = document.consumerBusiness.dob.value;
    var businessName = document.consumerBusiness.businessName.value;
    var panDetails = document.consumerBusiness.panDetails.value;
    var email = document.consumerBusiness.email.value;
    var phone = document.consumerBusiness.phone.value;
    var website = document.consumerBusiness.website.value;
    var businessOverview = document.consumerBusiness.businessOverview.value;
    var agentName = document.consumerBusiness.agentName.value;
    var agentID = document.consumerBusiness.agentID.value;
    var businessCategory = document.consumerBusiness.businessCategory.value;
    var businessType = document.consumerBusiness.businessType.value;
    var businessTurnover = document.consumerBusiness.businessTurnover.value;
    var capitalInvested = document.consumerBusiness.capitalInvested.value;
    var totalEmployees = document.consumerBusiness.totalEmployees.value;
    var businessAge = document.consumerBusiness.businessAge.value;

    if (firstName.length <= 1 || businessName.length >= 20) {
        alert("Name cannot be less than 1 characters long and less than 20 characters.");
        return false;
    } else if (lastName.length <= 1 || businessName.length >= 20) {
        alert("lastName must be at least 1 characters long and less than 20 characters");
        return false;
    }
    // else if (dob.length < 1) {
    //     alert("lastName must be at least 1 characters long.");
    //     return false;
    // } 
    else if (businessName.length <= 1 || businessName.length >= 20) {
        alert("businessName must be at least 1 character and less than 20 characters.");
        return false;
    } else if (panDetails.length != 12) {
        alert("panDetails must be 12 characters long.");
        return false;
    } else if (!(email.match(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/))) {
        alert("Enter valid Mail Details.");
        return false;
    } else if (phone.length != 10) {
        alert("phone number must be at 10 characters long.");
        return false;
    } else if (website.length <= 1 || website.length >= 20) {
        alert("website must be at least 1 characters long and less than 20 characters.");
        return false;
    }
    // else if (!(website.match("(([\w]+:)?//)?(([\d\w]|%[a-fA-F\d]{2,2})+(:([\d\w]|%[a-fA-f\d]{2,2})+)?@)?([\d\w][-\d\w]{0,253}[\d\w]\.)+[\w]{2,4}(:[\d]+)?(/([-+_~.\d\w]|%[a-fA-f\d]{2,2})*)*(\?(&?([-+_~.\d\w]|%[a-fA-f\d]{2,2})=?)*)?(#([-+_~.\d\w]|%[a-fA-f\d]{2,2})*)?"))) {
    //     alert("Enter valid Mail Details.");
    //     return false;
    // }
    else if (businessOverview.length <= 1 || businessOverview.length >= 50) {
        alert("businessOverview must be at least 1 characters long and less than 50 characters");
        return false;
    } else if (agentName.length <= 1 || agentName.length >= 20) {
        alert("website must be at least 1 characters long and less than 20 characters..");
        return false;
    } else if (isNaN(agentID) || agentID <= 0 || agentID >= 100000000) {
        alert("agentId must be Numeric Type.");
        return false;
    } else if (businessCategory.length <= 1 || businessCategory.length >= 20) {
        alert("businessCategory must be at least 1 characters long and less than 20 characters..");
        return false;
    } else if (businessType.length <= 1 || businessType.length >= 20) {
        alert("businessType must be at least 1 characters long and less than 20 characters..");
        return false;
    } else if (isNaN(businessTurnover) || businessTurnover <= 0 || businessTurnover >= 100000000) {
        alert("businessTurnover must be Numeric Type.");
        return false;
    } else if (isNaN(capitalInvested) || capitalInvested <= 0 || capitalInvested >= 100000000) {
        alert("capitalInvested must be Numeric Type.");
        return false;
    } else if (isNaN(totalEmployees) || totalEmployees <= 0 || totalEmployees >= 100000000) {
        alert("totalEmployees must be Numeric Type.");
        return false;
    } else if (isNaN(businessAge) || businessAge >= 100) {
        alert("businessAge must be Numeric Type.");
        return false;
    } else if (businessTurnover == capitalInvested) {
        document.consumerBusiness.businessTurnover.focus();
        document.consumerBusiness.capitalInvested.focus();
        alert("businessTurnover and capitalInvested cannot be equal.");
        return false;
    } else if (businessTurnover < capitalInvested) {
        document.consumerBusiness.businessTurnover.focus();
        document.consumerBusiness.capitalInvested.focus();
        alert("businessTurnover will be greater than capitalInvested value.");
        return false;
    } else {
        return true;
    }

}


function validateBusinessForm() {
    var consumerId = document.createBusinessPropertyForm.consumerId.value;
    var insuranceType = document.createBusinessPropertyForm.insuranceType.value;
    var propertyType = document.createBusinessPropertyForm.propertyType.value;
    var buildingSqft = document.createBusinessPropertyForm.buildingSqft.value;
    var buildingType = document.createBusinessPropertyForm.buildingType.value;
    var buildingStoreys = document.createBusinessPropertyForm.buildingStoreys.value;
    var buildingAge = document.createBusinessPropertyForm.buildingAge.value;
    var costOfTheAsset = document.createBusinessPropertyForm.costOfTheAsset.value;
    var salvageValue = document.createBusinessPropertyForm.salvageValue.value;
    var usefulLifeOfTheAsset = document.createBusinessPropertyForm.usefulLifeOfTheAsset.value;


    if (isNaN(consumerId) && consumerId <= 0) {
        alert("consumerId must be Numeric Type.");
        return false;
    } else if (insuranceType == null || insuranceType == "") {
        alert("Please choose Insurance Type.");
        return false;
    } else if (propertyType == null || propertyType == "") {
        alert("Please choose Property Type.");
        return false;
    } else if (buildingSqft.length <= 1) {
        alert("buildingSqft must be at least 1 characters long and less than 10 characters.");
        return false;
    } else if (buildingSqft.length >= 10) {
        alert("buildingSqft must be at least less than 10 characters.");
        return false;
    } else if (buildingType == null || buildingType == "") {
        alert("Please choose owner Type.");
        return false;
    } else if (buildingStoreys.length <= 1) {
        alert("buildingStoreys must be at least 1 characters long");
        return false;
    } else if (buildingStoreys.length >= 20) {
        alert("buildingStoreys must be at least less than 20 characters.");
        return false;
    } else if (isNaN(buildingAge) || buildingAge <= 0 || buildingAge >= 100000000) {
        alert("businessAge must be Numeric Type.");
        return false;
    } else if (isNaN(costOfTheAsset) || costOfTheAsset <= 0 || costOfTheAsset >= 100000000) {
        alert("costOfTheAsset must be Numeric Type.");
        return false;
    } else if (isNaN(salvageValue) || salvageValue <= 0 || salvageValue >= 100000000) {
        alert("salvageValue must be Numeric Type.");
        return false;
    } else if (isNaN(usefulLifeOfTheAsset) || usefulLifeOfTheAsset <= 0 || usefulLifeOfTheAsset >= 100) {
        alert("usefulLifeOfTheAsset must be Numeric Type.");
        return false;
    } else if (costOfTheAsset == salvageValue) {
        alert("costOfTheAsset and salvageValue cannot be equal.");
        return false;
    } else {
        return (true);
    }

}

function validateIssueForm() {
    var policyid = document.issuePolicy.policyid.value;
    var consumerid = document.issuePolicy.consumerid.value;
    var businessid = document.issuePolicy.businessid.value;
    var paymentdetails = document.issuePolicy.paymentdetails.value;
    var acceptancestatus = document.issuePolicy.acceptancestatus.value;

    if (isNaN(consumerid) || consumerid <= 0 || consumerid >= 1000000) {
        alert("consumerId must be Numeric Type.");
        return false;
    } else if (isNaN(businessid) || businessid <= 0 || businessid >= 1000000) {
        alert("businessId must be Numeric Type.");
        return false;
    } else if (policyid.length <= 1 || policyid.length >= 10) {
        alert("policyid must be at least less than 10 characters.");
        return false;
    } else if (paymentdetails.length <= 1 || paymentdetails.length >= 10) {
        alert("policyid must be at least less than 10 characters.");
        return false;
    } else if (acceptancestatus.length <= 1 || acceptancestatus.length >= 10) {
        alert("policyid must be at least less than 10 characters.");
        return false;
    } else {
        return (true);
    }

}



function validatePolicyForm() {
    var policyid = document.viewPolicy.policyId.value;
    var consumerid = document.viewPolicy.consumerId.value;
    if (isNaN(consumerid) || consumerid <= 0 || consumerid >= 1000000) {
        alert("consumerId must be Numeric Type and greater than 0.");
        return false;
    }
    // else if (isNaN(policyid) || policyid <= 0 || policyid >= 1000000) {
    //     alert("policyid must be Numeric Type and greater than 0.");
    //     return false;
    // } 
    else {
        return (true);
    }
}