document.getElementById("postForm").addEventListener("submit", function (event) {
    event.preventDefault(); // 防止表單提交的默認行為

    var postContent = document.getElementById("postContent").value;
    var postImage = document.getElementById("postImage").files[0];

    // 在這裡可以將文章內容和圖片提交到後端進行處理




    
    // 清空表單
    document.getElementById("postContent").value = "";
    document.getElementById("postImage").value = "";
});
