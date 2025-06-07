const images = {
    group1: [
        "고양이1.jpg", "고양이2.jpg", "고양이3.jpg", "고양이4.jpg", "고양이5.jpg", "고양이6.jpg",
        "고양이7.jpg", "고양이8.jpg", "고양이9.jpg", "고양이10.jpg", "고양이11.jpg", "고양이12.jpg",
        "고양이13.jpg", "고양이14.jpg", "고양이15.jpg", "고양이16.jpg", "고양이17.jpg", "고양이18.jpg",
        "고양이19.jpg", "고양이20.jpg", "고양이21.jpg", "고양이22.jpg", "고양이23.jpg", "고양이24.jpg",
        "고양이25.jpg", "고양이26.jpg", "고양이27.jpg", "고양이28.jpg", "고양이29.jpg", "고양이30.jpg"
    ],
    group2: [
        "덤벨로우.jpg","바벨로우.png","풀업.jpg","렛풀다운.jpg","시티로우.jpg","암풀다운.jpg",
        "벤치프레스.jpg","덤벨프레스.jpg","딥스.jpg","버터플라이.jpg","케이블크로스오버.jpg","머신체스트프레스.jpg",
        "페이스풀.jpg","밀리터리프레스png.png","사레레png.png","덤벨숄더프레스.jpg","머신숄터프레스.jpg","업라이트 로우.jpg",
        "런지.jpg","스쿼트png.png","레그프레스png.png","레그익스텐션.jpg","힙업브덕션.jpg","시티드레그컬.jpeg",
        "덤벨컬.jpg","프리쳐컬.jpg","케이블컬png.png","라잉트라이셉스익스텐션.jpg","케이블푸쉬다운png.png","오버헤드익스텐션png.png"
    ]
};

let currentGroup = 'group1';
let currentPage = 1;
let currentImageIndex = 0;
const itemsPerPage = 6;

function renderGallery() {
    const gallery = document.getElementById('gallery');
    gallery.innerHTML = '';
    const start = (currentPage - 1) * itemsPerPage;
    const end = start + itemsPerPage;
    images[currentGroup].slice(start, end).forEach((src, idx) => {
        const img = document.createElement('img');
        img.src = src;
        img.onclick = () => openModal(start + idx);
        gallery.appendChild(img);
    });
}

function renderPagination() {
    const totalPages = Math.ceil(images[currentGroup].length / itemsPerPage);
    const pagination = document.getElementById('pagination');
    pagination.innerHTML = '';

    if (currentGroup === 'group2') {
        const pageLabels = ['월(등)', '화(가슴)', '수(어깨)', '금(하체)', '일(이두,삼두)'];
        for (let i = 1; i <= totalPages; i++) {
            const btn = document.createElement('button');
            btn.textContent = pageLabels[i - 1] || i;
            btn.onclick = () => {
                currentPage = i;
                renderGallery();
            };
            pagination.appendChild(btn);
        }
    } else {
        for (let i = 1; i <= totalPages; i++) {
            const btn = document.createElement('button');
            btn.textContent = i;
            btn.onclick = () => {
                currentPage = i;
                renderGallery();
            };
            pagination.appendChild(btn);
        }
    }
}

function switchGroup(group) {
    currentGroup = group;
    currentPage = 1;
    renderGallery();
    renderPagination();
}

function openModal(index) {
    currentImageIndex = index;
    const modal = document.getElementById('modal');
    const modalImg = document.getElementById('modalImg');
    modalImg.src = images[currentGroup][index];
    modal.style.display = 'flex';
}

function closeModal(event) {
    // 모달 바깥 영역 클릭 시만 닫히게
    if (event.target.id === 'modal') {
        document.getElementById('modal').style.display = 'none';
    }
}

function showPrevImage() {
    if (currentImageIndex > 0) {
        currentImageIndex--;
        document.getElementById('modalImg').src = images[currentGroup][currentImageIndex];
    }
}

function showNextImage() {
    if (currentImageIndex < images[currentGroup].length - 1) {
        currentImageIndex++;
        document.getElementById('modalImg').src = images[currentGroup][currentImageIndex];
    }
}

switchGroup('group1');