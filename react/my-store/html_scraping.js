import axios from 'axios';
import { JSDOM } from 'jsdom';


// npm install jsdom
//구글 뉴스
const URL = 'https://news.google.com/home?hl=ko&gl=KR&ceid=KR:ko';

async function scrapingPractice(URL) {
  const response = await axios(URL);

  const data = response.data;

  const dom = new JSDOM(data);

  const document = dom.window.document;

  // article 태그 모두 선택
  const articles = document.querySelectorAll('article');

  // article 태그들을 반복하며
  articles.forEach((article) => {
    // 그 안의 a태그를 찾아서
    const aTags = article.querySelectorAll('a');
    // 그들의 text를 출력하자
    aTags.forEach((aTag) => {
      if (aTag.textContent) console.log(aTag.textContent);
    });
  });
}

scrapingPractice(URL);
