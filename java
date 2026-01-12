const dropdown = document.querySelector('.dropdown');

dropdown.addEventListener('click', () => {
    const menu = dropdown.querySelector('.dropdown-menu');
    menu.style.display = menu.style.display === 'block' ? 'none' : 'block';
});

document.querySelectorAll('.dropdown-toggle').forEach(toggle => {
    toggle.addEventListener('click', (e) => {
        e.preventDefault();

        const menu = toggle.nextElementSibling;
        menu.classList.toggle('active');
    });
});
