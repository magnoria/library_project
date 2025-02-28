console.log("js확인용");

// 등록함수
const save = async () => {

    const mname = document.querySelector(".mname").value;
    const mphone = document.querySelector(".mphone").value;
    const maddress = document.querySelector(".maddress").value;
    const mbook = document.querySelector(".mbook").value;

    const obj = { mname , mphone , maddress , mbook};

    console.log(obj);

    axios.post('/member' , obj)
            .then( response => { console.log(response.data); findAll();})
            .catch(e => {console.log(e);})

}// f end

// 전체출력함수
const findAll = async () => {
try{
    const response = await axios.get('/member')
    console.log(response.data);
    const tbody = document.querySelector('tbody');
    let html = '';
        response.data.forEach( lib => {
            html += `
                 <tr>
                            <th> ${lib.mname} </th>
                            <th> ${lib.mphone}</th>
                            <th> ${lib.maddress}</th>
                            <th> ${lib.mbook}</th>

                            <th><button type="button" onclick=update(${lib.mid})>수정</button></th>
                            <th><button type="button" onclick=delete(${lib.mid})>삭제</button></th>
                 </tr>
            `

        })
        tbody.innerHTML = html;
        }catch(e){console.log(e)}
} // f end
 findAll();


 //수정함수
 const update = async (mid) => {
    const mname = promprt('새로운 이름')
    const mphone = promprt('새로운 번호')
    const maddress = promprt('새로운 주소')
    const mbook = promprt('대여한책')

    const obj = { mname , mphone , maddress , mbook};

    const response = await axios.put(/member , obj)


 }