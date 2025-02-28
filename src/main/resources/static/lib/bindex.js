console.log("bindex확인용");

//등록함수
const bsave = async () => {

  const btitle = document.querySelector(".btitle").value;
  const writer = document.querySelector(".writer").value;
  const publisher = document.querySelector(".publisher").value;
  const stock = document.querySelector(".stock").value;

  const obj = { btitle , writer , publisher , stock};

  axios.post('/book' , obj)
    .then(response => {console.log(response.data); findAll();})
    .catch(e => {console.log(e);})


}

//전체 출력함수
const findAll = async () => {
    try{
        const response = await axios.get('/book')

        const tbody = document.querySelector('tbody');
        let html = '';
            response.data.forEach( lib => {
                html += `
                        <tr>
                         <th> ${lib.btitle} </th>
                         <th> ${lib.writer}</th>
                         <th> ${lib.publisher}</th>
                         <th> ${lib.stock}</th>

                        <th><button type="button" onclick=update(${lib.bno})>수정</button></th>
                        <th><button type="button" onclick=ondelete(${lib.bno})>삭제</button></th>
                        <th><button type="button" onclick=findOne(${lib.bno})>개별조회</button></th>
                    </tr>
                `

            })
        tbody.innerHTML = html;
    }catch(e) {console.log(e)}

}// f end
findAll();

//수정함수
const update = async (mbno) => {
    const bno = mbno;
    const btitle = prompt('수정할 제목')
    const writer = prompt('수정할 작가')
    const publisher = prompt('수정할 출판사')
    const stock = prompt('수정할 제고')

    const obj = { bno : mbno , btitle, writer ,publisher , stock};

    const response = await axios.put('/book' , obj)
    if(response.data == true) {findAll();}

}

//삭제함수
const ondelete = async (bno) => {

const response = await axios.delete(`/book?bno=${bno}`)
if(response.data == true) {findAll();}

}




//개별출력함수]
const findOne = async (bno) => {
    try{
    const response = await axios.get(`/book/view?bno=${bno}`)
    const lib = response.data;
    const table =document.querySelector('.fortun')
    let html = '';
        html += `
                     <tr>
                           <th> ${lib.btitle}</th>
                           <th> ${lib.writer}</th>
                           <th> ${lib.publisher}</th>
                           <th> ${lib.stock}</th>
                     </tr>

                `
    table.innerHTML = html;
    }catch(e) {console.log(e)}


}