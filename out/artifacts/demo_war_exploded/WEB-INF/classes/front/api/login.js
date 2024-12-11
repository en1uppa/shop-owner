function getUser(data) {
    return $axios({
        'url': '/user/getUser',
        'method': 'post',
        data
    })
}