const bodyContainer = document.querySelector('.submit_array')

export function displayArrayOnScreen(array)
{
    const arrayDiv = document.createElement("div")
    const arrayString = arrayToString(array)

    arrayDiv.innerHTML = arrayString
    displayStyling(arrayDiv)

    bodyContainer.appendChild(arrayDiv)

    return arrayDiv


}

function displayStyling(div)
{
    div.style.textAlign = 'center'
    div.style.fontSize = '150px'
    div.style.position = 'relative'
    div.style.top = '200px'

    
}

export function applyAnimation(div)
{
    div.style.animation = "arrayDisappear 1s ease-out forwards"
    div.style.animationDelay = '1s'
}

function arrayToString(array)
{
    return array.toString()
}