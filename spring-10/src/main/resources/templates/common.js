
const urlGetAllAuthors = '/api/authors/';
const urlGetAllGenres = '/api/genres/';

const urlBookApi = '/api/books/';

const jsonRequestHeader = {'Accept': 'application/json', 'Content-Type': 'application/json'}

let localizedMessages = new Map([
    ['error', 'Error'],
    ['error.detail', 'Details'],
    ['error.status.400', 'Bad Request'],
    ['error.status.404', 'Not Found'],
    ['error.status.405', 'Method Not Allowed'],
    ['error.status.500', 'Internal Server Error'],
]);


async function getDataAndApply(url, successFunction) {
        let response = await fetch(url,
            {
                method: "GET", headers: jsonRequestHeader
            });
        let data = await response.json();
                successFunction(data);

}