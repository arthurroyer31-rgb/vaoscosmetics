document.querySelectorAll('.dropdown-toggle').forEach(toggle => {
  toggle.addEventListener('click', e => {
    e.preventDefault();
    const menu = toggle.nextElementSibling;
    menu.classList.toggle('active');
  });
});
