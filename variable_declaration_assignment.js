/*
JS variablbe declaration and assignment
*/
So returning to the original problem:

  var text = 'outside';
function logIt(){
    console.log(text);
    var text = 'inside';
};
logIt();
JavaScript
The declaration (but not the assignment) of text gets hoisted to the top of logIt(). So our code gets interpreted as though it were:

  var text = 'outside';
function logIt(){
    var text;
    console.log(text);
    text = 'inside';
};
logIt();
JavaScript
So we have a new variable text inside of logIt() that is initialized to undefined, which is what it holds when we hit our log statement.