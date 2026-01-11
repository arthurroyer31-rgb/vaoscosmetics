const dropdown = document.querySelector('.dropdown');

dropdown.addEventListener('click', () => {
    const menu = dropdown.querySelector('.dropdown-menu');
    menu.style.display = menu.style.display === 'block' ? 'none' : 'block';
});