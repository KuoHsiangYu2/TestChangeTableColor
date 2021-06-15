console.log('index.js');

function testEncode(inputValue) {
    let seed = 1;
    let newStr = encode(inputValue, seed);
    return newStr;
}

function encode(inStr, seed) {
    seed = parseInt(seed, 10);
    let char = ' ', index = 0, newIndex = 0, outStr = '';
    let refStr = '0123456789abcdefghijklmnopqrstuvwxyz._~ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    for (let i = 0; i < inStr.length; i++) {
        char = inStr.substring(i, i + 1);
        index = refStr.indexOf(char);
        newIndex = index ^ seed;
        outStr = outStr + refStr.substring(newIndex, newIndex + 1);
    }
    return String(outStr).toString();
}

jQuery('#submitButton').on('click', function (event) {
    let accountIdText = jQuery('#accountId').get(0).value;
    let passwordIdText = jQuery('#passwordId').get(0).value;
    accountIdText = testEncode(accountIdText);
    passwordIdText = testEncode(passwordIdText);
    if (accountIdText !== 'bcnjm' || passwordIdText !== 'bcnjm') {
        window.alert('帳號密碼錯誤。');
        return;
    }
    document.formName1.submit();
});

// http://mirlab.org/jang/books/javascript/password.asp?title=11-1%20%BA%F4%A7}%ABO%C5@
