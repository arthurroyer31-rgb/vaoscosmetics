document.querySelectorAll('.dropdown-toggle').forEach(toggle => {
    toggle.addEventListener('click', (e) => {

        // Mobile uniquement
        if (window.matchMedia("(hover: none)").matches) {

            const menu = toggle.nextElementSibling;

            // Ferme les autres
            document.querySelectorAll('.dropdown-menu').forEach(m => {
                if (m !== menu) m.classList.remove('active');
            });

            menu.classList.toggle('active');
        }
    });
});
document.addEventListener('click', (e) => {
    if (window.matchMedia("(hover: none)").matches) {
        document.querySelectorAll('.dropdown').forEach(dropdown => {
            if (!dropdown.contains(e.target)) {
                dropdown.querySelector('.dropdown-menu').classList.remove('active');
            }
        });
    }
});

