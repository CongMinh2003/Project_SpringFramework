
document.addEventListener("DOMContentLoaded", function () {
    const slides = document.querySelectorAll('.list-images img');
    const prevBtn = document.querySelector('.btn-left');
    const nextBtn = document.querySelector('.btn-right');
    let currentSlide = 0;

    // Hàm để hiển thị hình ảnh tương ứng với chỉ số
    function showSlide(index) {
        slides.forEach((slide, i) => {
            if (i === index) {
                slide.style.display = 'block';
            } else {
                slide.style.display = 'none';
            }
        });
    }

    // Hiển thị slide đầu tiên khi trang được tải
    showSlide(currentSlide);

    // Xử lý khi nhấn nút trái
    prevBtn.addEventListener('click', function () {
        currentSlide = (currentSlide - 1 + slides.length) % slides.length;
        showSlide(currentSlide);
    });

    // Xử lý khi nhấn nút phải
    nextBtn.addEventListener('click', function () {
        currentSlide = (currentSlide + 1) % slides.length;
        showSlide(currentSlide);
    });

    // Tự động chuyển đổi hình ảnh sau mỗi 0.5 giây
    setInterval(function () {
        currentSlide = (currentSlide + 1) % slides.length;
        showSlide(currentSlide);
    }, 70000); // 500 milliseconds = 0.5 seconds
});

