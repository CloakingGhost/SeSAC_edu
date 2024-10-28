const BASE_URL = 'http://apis.data.go.kr/B552584/ArpltnInforInqireSvc'

// Decoding API Key
const serviceKey = "vw2EnZ0GgIZHggwDsu7aUHke764BQdqeKf5lKhPTeHutsRpAtgmD7OJlVeTbpbB2TIZ4RavZN01PSlcYZx+2aA=="
const returnType = 'json'
const sidoName = '서울'
const ver = '1.0'
const numOfRows = 100
/* 
한국환경공단_에어코리아_대기오염정보_기술문서_v1.2.docx

1. 미세먼지(`한국환경공단_에어코리아_대기오염정보`)관련 API를 활용하여 다음 질문에 답하시오.
    1. `시도별 실시간 측정정보 조회`에서  확인 가능한 시도 이름을 전부 작성하시오.
        1. query parameter에 넣을 수 있는 이름이 무엇일까?
        시도 이름(전국, 서울, 부산, 대구, 인천, 광주, 대전, 울산, 경기, 강원, 충북, 충남, 전북, 전남, 경북, 경남, 제주, 세종)
    2. `시도별 실시간 측정정보 조회`의 `서울`의 데이터에 대해, 초 미세먼지 농도가 가장 낮은 `stationName`을 찾으시오.
        1. 초 미세먼지 농도는 어떤 key값으로 표현이 될까?
    3. `시도별 실시간 측정정보 조회`의 `서울`의 데이터를 `stationName`으로 접근하기 쉬운 자료구조로 재구성하시오. 
        1. 그런 자료구조는 무엇일까?
    4. `종로구`의 `pm10Value`, `pm25Value`의 1달치 데이터를 정리하시오.
        1. 1달치 데이터는 어떻게 가져올까? 
*/
const paramsObject = {
  serviceKey: serviceKey,
  returnType: returnType,
  sidoName: sidoName,
  ver: ver,
  numOfRows: numOfRows
}
function getParams() {
  return paramsObject
}
function updateParams(params) {
  for (const key in params) {
    // console.log(key, params[key])
    if (!paramsObject[key])
      paramsObject[key] = params[key]
  }
  return getParams()
}
function deleteParams(params) {

  for (const key of params) {
    if (paramsObject[key]) {
      // console.log(key)
      delete paramsObject[key]
    }
  }
  return getParams()
}
function updatePath(newPath) {
  if (newPath[0] !== "/") newPath = `/${newPath}`
  return newPath
}

function makeURL(url, path, params) {
  try {
    path = updatePath(path)
    params = new URLSearchParams(params)
    return `${url}${path}?${params}`
  } catch (error) {
    return error
  }
}
async function getInfo(URL) {
  const response = await fetch(URL)
  return await response.json()
}

function getLowPM25(data) {
  return data.reduce((acc, cur) => {

    if (isNaN(parseInt(cur.pm25Value))) return acc

    return parseInt(acc.pm25Value) > parseInt(cur.pm25Value) ? cur : acc

  }, data[0])


}

function refectorStructure(data) {
  const result = {}
  data.forEach(el => {
    // console.log(el)
    if (!result[el.stationName]) {
      result[el.stationName] = new Array(el)
    } else {
      result[el.stationName].push(el)
    }
  });

}

async function main() {
  let path = updatePath("getCtprvnRltmMesureDnsty")
  // console.log(paramsObject)
  let URL = makeURL(BASE_URL, path, paramsObject)
  console.log(URL);

  const seoulInfo = await getInfo(URL)
  const items = seoulInfo.response.body.items
  const lowPM25 = getLowPM25(items)
  refectorStructure(items)

  path = updatePath("getMsrstnAcctoRltmMesureDnsty")
  const addParams = { stationName: "종로구", dataTerm: "MONTH" }
  const removeParams = ["sidoName"]
  updateParams(addParams)
  deleteParams(removeParams)


  URL = makeURL(BASE_URL, path, paramsObject)
  console.log(URL);

  const monthlyJongNo = await getInfo(URL)
  const itemsByJongNo = monthlyJongNo.response.body.items
  for (const item of itemsByJongNo) {
    console.log(item.dataTime,"\t", item.pm10Value, item.pm25Value)
  }

}

main()

