import axios from 'axios'

const AXIOS = axios.create({
  baseURL: `/api`,
  timeout: 1000
});

export default {
    nlcBrowseCars() {
        return AXIOS.get(`/nlc/browsecars`);
    },

    lcMakeOrder(params) {
        return AXIOS.post('/lc/makeorder',params);
    }
}