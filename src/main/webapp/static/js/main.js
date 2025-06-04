document.addEventListener('DOMContentLoaded', function() {
    // 表单验证
    const forms = document.querySelectorAll('form');

    forms.forEach(form => {
        form.addEventListener('submit', function(e) {
            let valid = true;
            const inputs = this.querySelectorAll('input[required], textarea[required]');

            inputs.forEach(input => {
                if (!input.value.trim()) {
                    valid = false;
                    input.style.borderColor = '#e74c3c';
                } else {
                    input.style.borderColor = '#ddd';
                }
            });

            if (!valid) {
                e.preventDefault();
                alert('请填写所有必填字段');
            }
        });
    });

    // 显示/隐藏密码
    const passwordToggles = document.querySelectorAll('.password-toggle');

    passwordToggles.forEach(toggle => {
        toggle.addEventListener('click', function() {
            const input = this.previousElementSibling;
            if (input.type === 'password') {
                input.type = 'text';
                this.textContent = '隐藏';
            } else {
                input.type = 'password';
                this.textContent = '显示';
            }
        });
    });

    // 平滑滚动
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function(e) {
            e.preventDefault();
            document.querySelector(this.getAttribute('href')).scrollIntoView({
                behavior: 'smooth'
            });
        });
    });
});


// 评论表单提交后平滑滚动到新评论
document.querySelectorAll('.comment-form').forEach(form => {
    form.addEventListener('submit', function(e) {
        // 可以在这里添加表单验证
        // 提交后页面会刷新，由服务器端处理重定向
    });
});

// 可选：实现AJAX评论提交以提升用户体验
/*
document.querySelectorAll('.comment-form').forEach(form => {
    form.addEventListener('submit', function(e) {
        e.preventDefault();
        const formData = new FormData(this);
        const postId = this.action.split('/').slice(-2, -1)[0];

        fetch(this.action, {
            method: 'POST',
            body: formData
        })
        .then(response => response.text())
        .then(html => {
            // 更新评论区域
            const commentsSection = this.closest('.comments-section');
            commentsSection.innerHTML =
                new DOMParser().parseFromString(html, 'text/html')
                .querySelector('.comments-section').innerHTML;
        })
        .catch(error => console.error('Error:', error));
    });
});
*/