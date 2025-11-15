const apiUrl = 'http://localhost:8080/api/ofertas';

async function cargarOfertas(){
  try {
    const res = await fetch(apiUrl);
    if(!res.ok) throw new Error('Error al obtener ofertas');
    const data = await res.json();
    const cont = document.getElementById('lista-ofertas');
    cont.innerHTML = '';
    data.forEach(o => {
      const div = document.createElement('div');
      div.className = 'oferta';
      div.innerHTML = `<strong>${o.titulo}</strong><p>${o.descripcion || ''}</p><small>${o.ubicacion || ''}</small>`;
      cont.appendChild(div);
    });
  } catch(err) {
    console.error(err);
    document.getElementById('lista-ofertas').innerText = 'No se pudieron cargar las ofertas.';
  }
}

window.onload = cargarOfertas;
