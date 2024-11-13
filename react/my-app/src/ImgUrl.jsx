import React from 'react'
const imgUrls = [
  "https://images.dog.ceo/breeds/gaddi-indian/Gaddi.jpg",
  "https://images.dog.ceo/breeds/terrier-westhighland/n02098286_3154.jpg",
  "https://images.dog.ceo/breeds/malamute/n02110063_16752.jpg",
  "https://images.dog.ceo/breeds/bulldog-english/jager-2.jpg",
];
export default function ImgUrl() {
  return (
    <div>
      {imgUrls.map((url, idx) =>
        <div key={idx + 1}>
          <img src={url} width={300} />
        </div>
      )}
    </div>
  )
}
