$(document).ready(function() {
    // 通过用户ID获取用户信息并显示
    const userId = '需要替换的用户ID'; // 这里应该动态获取或传入实际的用户ID
    getUserInfo(userId);

    function getUserInfo(userId) {
        $.ajax({
            url: `/user/getById/${userId}`,
            type: "GET",
            success: function(response) {
                if(response.status === "success") {
                    displayUserInfo(response.data);
                } else {
                    alert("获取用户信息失败，请重试！");
                }
            },
            error: function(err) {
                alert("加载用户信息失败，请检查网络连接！");
            }
        });
    }

    function displayUserInfo(user) {
        $('#userInfoDisplay').html(`
            <p>用户名: ${user.username}</p>
            <p>密码: *********</p> <!-- 注意：实际不应直接显示密码 -->
            <p>年龄: ${user.age}</p>
            <p>性别: ${user.gender}</p>
        `);

        // 预填充表单
        $('#username').val(user.username);
        $('#age').val(user.age);
        $('#gender').val(user.gender);
    }

    function updateUser() {
        const userData = {
            username: $('#username').val(),
            password: $('#password').val(),
            age: $('#age').val(),
            gender: $('#gender').val()
        };

        $.ajax({
            url: '/user/update',
            type: "POST",
            data: JSON.stringify(userData),
            contentType: "application/json; charset=utf-8",
            success: function(response) {
                if(response.status === "success") {
                    alert("用户信息更新成功！");
                } else {
                    alert("更新用户信息失败，请重试！");
                }
            },
            error: function(err) {
                alert("更新过程中发生错误，请检查网络或联系管理员！");
            }
        });
    }
});
