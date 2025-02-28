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

                            <th><button type="button" onclick=update(${lib.mno})>수정</button></th>
                            <th><button type="button" onclick=ondelete(${lib.mno})>삭제</button></th>
                            <th><button type="button" onclick=findOne(${lib.mno})>개별조회</button></th>
                 </tr>
            `

        })
        tbody.innerHTML = html;
        }catch(e){console.log(e)}
} // f end
 findAll();


 //수정함수
 const update = async (bmno) => {
    const mno = bmno;
    const mname = prompt('새로운 이름')
    const mphone = prompt('새로운 번호')
    const maddress = prompt('새로운 주소')
    const mbook = prompt('대여한책')

    const obj = { mno : bmno, mname , mphone , maddress , mbook};

    const response = await axios.put('/member' , obj)
    if( response.data == true){findAll();}


 }

 //삭제함수
 const ondelete = async (mno) => {

    const response = await axios.delete(`/member?mno=${mno}`)

    if( response.data == true){findAll();}



 }

 //개별 출력함수
 const findOne = async (mno) => {
    try{
    const response = await axios.get(`/member/view?mno=${mno}`)
    const lib = response.data;
    const table = document.querySelector('.fortun')
    let html = '';

            html += `
                        <tr>
                                    <th> ${lib.mname}</th>
                                    <th> ${lib.mphone}</th>
                                    <th> ${lib.maddress}</th>
                                    <th> ${lib.mbook}</th>
                                </tr>

                    `


        table.innerHTML = html;
        }catch(e){console.log(e);}


 }
