import api from './axios';

const endpoint = {
  posts: {
    get: '',
    getById: (postId) => `/${postId}`,
  },
};

const postApi = {
  // 1. 리스트 GET
  getPosts: async () => {
    const response = await api.get('');
    return response.data;
  },
  // 2. 개별 GET
  getPostById: async (postId) => {
    const response = await api.get(endpoint.posts.getById(postId));
    // const response = await api.get(`/${postId}`);
    return response.data;
  },
  // 3. POST
  createPost: async (formData) => {
    const response = await api.post(endpoint.posts.get, formData);
    // const response = await api.post('', formData);
    return response.data;
  },
};

export default postApi;
