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
const slides = document.querySelectorAll('.carousel-slide');
const prev = document.querySelector('.prev');
const next = document.querySelector('.next');
let currentIndex = 0;

function showSlide(index) {
    slides.forEach((slide, i) => {
        slide.classList.remove('active');
        slide.style.transform = `translateX(${100 * (i - index)}%)`;
    });
    slides[index].classList.add('active');
}

// Initialisation
showSlide(currentIndex);

// Boutons
prev.addEventListener('click', () => {
    currentIndex = (currentIndex - 1 + slides.length) % slides.length;
    showSlide(currentIndex);
});

next.addEventListener('click', () => {
    currentIndex = (currentIndex + 1) % slides.length;
    showSlide(currentIndex);
});

// Auto-slide (optionnel)
setInterval(() => {
    currentIndex = (currentIndex + 1) % slides.length;
    showSlide(currentIndex);
}, 5000);
