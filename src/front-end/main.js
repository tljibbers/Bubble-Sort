import { displayArrayOnScreen, applyAnimation } from "./arrayAnimations.js"

const form = document.getElementById('array-Form')
const bodyContainer = document.querySelector('.submit_array')
console.log(form)

function convertToArray(arrayChar)
{
    return arrayChar.split(' ')
}


function checkForChars(array)
{
    for(const x in array)
    {

        if(isNaN(array[x]))
        {
            alert("Only Integers are allowed. Try again.")
            return false
        }
        else
        {
            console.log("good")
        }
    }
    return true
}

function checkForLength(array)
{
    if(array.length < 3 || array.length > 8)
    {
        alert("Length should be between 3 and 8 integers. Try again.")
        return false
    }
    return true

}

form.addEventListener('submit', function(event){
    event.preventDefault();
    console.log("test")
    const arrayChar = document.getElementById('array').value
    const arrayConvert = convertToArray(arrayChar)
    if((checkForChars(arrayConvert) == true) && (checkForLength(arrayConvert) == true))
    {
        bodyContainer.removeChild(form)
        const test = displayArrayOnScreen(arrayConvert)
        setTimeout(applyAnimation(test), 3000)
        
    }
    else
    {
        console.log("falsed")
    }   
})
