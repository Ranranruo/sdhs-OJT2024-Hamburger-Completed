const $ = (selector) => document.querySelector(selector);
const $$ = (selector) => document.querySelectorAll(selector);
window.addEventListener('DOMContentLoaded', () => {
    const $form = $("form");

    // $form.addEventListener("submit", async (e) => {
    //     e.preventDefault();
    //     const id = e.target.id.value;
    //     const password = e.target.password.value;
    //     const member = JSON.stringify({ id, password });
    //
    //     fetch('/sign-in', {
    //         method: "POST",
    //         headers: {
    //             "Content-Type": "application/json"
    //         },
    //         body: member
    //     }).then(response => {
    //         if(response.status === 200) {
    //             return response.json();
    //         }
    //     }).then(member => {
    //         console.log(member);
    //     });
    // })
});