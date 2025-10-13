const bodyContainer = document.querySelector('.submit_array')
const button = document.createElement('button')
button.innerHTML = 'Try Again'



function displayStyling(div)
{
    div.style.textAlign = 'center'
    div.style.fontSize = '70px'
    div.style.gap = '20px'
    div.style.display = 'flex'
    div.style.justifyContent = 'center'
    div.style.alignItems = 'center'   
}

export function getNums(data, i)
{

    const arrayContainer = document.createElement('div')
    arrayContainer.id = 'array-Container'
    arrayContainer.innerHTML = 'Step' + ' ' + i + ':' + ' '
    console.log('called')
    console.log(data.steps[0].state)
    const lastIndex = data.steps.length - 1
    for(const x in data.steps[i].state)
    {
        const num = document.createElement('div')
        num.id = 'number' + '-' + i
        num.innerHTML = data.steps[i].state[x]
        console.log(num.innerHTML)
        const index1 = data.steps[i].index1
        const index2 = data.steps[i].index2

        if(data.steps[i].state[x] == data.steps[i].state[index1])
        {
            num.style.color = 'green'
        }
        if(data.steps[i].state[x] == data.steps[i].state[index2])
        {
            num.style.color = 'blue'
        }
        if(data.steps[i] == data.steps[lastIndex])
        {
            num.style.color = 'lightgreen'
        }

        arrayContainer.appendChild(num)
    }

    displayStyling(arrayContainer)
    bodyContainer.appendChild(arrayContainer)
    applyAnimation(arrayContainer)
    bodyContainer.appendChild(button)
    button.addEventListener('click', function(){
        window.location.reload()
    })
}


export function applyAnimation(div)
{
    div.style.animation = "arrayDisappear 1s ease-out forwards"
    
}

