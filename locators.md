<tagName attribute="value" attribute2="value2" attribute3 >

</tagName>

absolute xpath:

/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea

relative xpath:

NODE -> //tagName[@attibute='value']

//*[@attibute='value']

//tagName

//tagName[@attibute='value'][@attibute2='value2']

//tagName[@attibute3]

(//tagName[@attibute='value'])[index]

//tagName[text()='textValue']

//tagName[contains(text(),'partialTextValue')]

//tagName[contains(.,'partialTextValue')]

xpath axis:

//td[text()='Ernst Handel']/following-sibling::td[1]

//td[text()='Ernst Handel']/parent::tr/td[2]

dynamic xpath