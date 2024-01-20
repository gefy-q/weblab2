const rValue = 160; //px
const centerX = 202; //px
const centerY = 210; //px
function validateForm() {
    const x = parseFloat(document.getElementById("inputX").value);
    const y = parseFloat(document.getElementById("inputY").value);
    const r = parseFloat(document.getElementById("inputR").value);
    performCheck(x, y, r);
    return false;
}
function performCheck(x, y, r) {
    const resultsBody = document.getElementById("results-body");
    if (isNaN(x) || isNaN(y) || isNaN(r) ||
        y < -3 || y > 5 || r < 2 || r > 5 || x < -5 || x > 3) {
        alert("Ошибка: некорректные данные");
        return;
    }
    fetch(`ControllerServlet`, {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
              },
            body: `x=${x}&y=${y}&r=${r}`
        })
        .then((response) => response.text())
        .then((data) => {
            resultsBody.innerHTML = data;
            transformIntoDot(x, y, r, data);
        })
        .catch((error) => alert(error));
}
function imageCheck(e) {
    e.preventDefault();
    const r = parseFloat(document.getElementById("inputR").value);
    if (isNaN(r) || r < 2 || r > 5) {
        alert("Задайте корректное значение R для проверки на изображении");
        return;
    }
    const offsetX = e.offsetX - centerX;
    const offsetY = centerY - e.offsetY;
    const x = offsetX / rValue * r;
    const y = offsetY / rValue * r;
    performCheck(x, y, r);
}
function transformIntoDot(x, y, r, data) {
    const success = data.lastIndexOf("Попадание") > data.lastIndexOf("Непопадание");
    const offsetX = x * rValue / r;
    const offsetY = y * rValue / r;
    const dotX = centerX + offsetX - 5;
    const dotY = centerY - offsetY - 5;
    if(dotX < 0 || dotY < 0 || dotX > 406 || dotY > 411)
        return;
    let dot = document.createElement("div");
    dot.setAttribute("class", `${success ? "green" : "red"} dot`);
    dot.setAttribute("style", `top: ${dotY}px; left:${dotX}px;`);
    document.getElementById("image-block").appendChild(dot);
}