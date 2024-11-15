import axios from 'axios';
import { JSDOM } from 'jsdom';
import puppeteer from 'puppeteer';

// npm install puppeteer
// 네이버 웹툰
const URL = 'https://comic.naver.com/webtoon?tab=fri';

async function scrapingPractice(URL) {
  const browser = await puppeteer.launch({
    headless: true,
  });

  const page = await browser.newPage();

  const response = await page.goto(URL);
  console.log(response);
  // const text = await page.$eval('h1', (el) => el.textContent);
  // console.log(text);

  const imgUrls = await page.waitForSelector('#content ul img');

  console.log(imgUrls);
}

scrapingPractice(URL);
