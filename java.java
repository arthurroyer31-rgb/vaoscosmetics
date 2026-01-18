function renderCart() {
  const cartContainer = document.querySelector('.cart-items');
  const cart = JSON.parse(localStorage.getItem('cart')) || [];
  cartContainer.innerHTML = '';

  let total = 0;

  cart.forEach((item, index) => {
    const itemTotal = item.price * item.qty;
    total += itemTotal;

    const div = document.createElement('div');
    div.classList.add('cart-item');
    div.innerHTML = `
      <img src="${item.img}" alt="${item.name}" class="cart-item-img">
      <div class="cart-item-info">
        <h3>${item.name}</h3>
        <div>Prix unitaire : ${item.price.toFixed(2)} €</div>
        <div>
          Quantité: <input type="number" min="1" value="${item.qty}" class="qty" data-index="${index}">
        </div>
        <div class="cart-item-price" data-price="${item.price}">${itemTotal.toFixed(2)} €</div>
        <button class="remove" data-index="${index}">Supprimer</button>
      </div>
    `;
    cartContainer.appendChild(div);
  });

  document.querySelector('.total').textContent = total.toFixed(2) + " €";

  // Gestion des changements de quantité
  document.querySelectorAll('.qty').forEach(input => {
    input.addEventListener('change', e => {
      const idx = e.target.dataset.index;
      cart[idx].qty = parseInt(e.target.value);
      localStorage.setItem('cart', JSON.stringify(cart));
      renderCart();
    });
  });

  // Gestion des suppressions
  document.querySelectorAll('.remove').forEach(btn => {
    btn.addEventListener('click', e => {
      const idx = e.target.dataset.index;
      cart.splice(idx, 1);
      localStorage.setItem('cart', JSON.stringify(cart));
      renderCart();
    });
  });
}

// Initialisation
renderCart();
