<template>

<v-data-table
    :headers="headers"
    :items="roomview"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'Roomview',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "id", value: "id" },
            { text: "desc", value: "desc" },
            { text: "reviewCnt", value: "reviewCnt" },
            { text: "roomStatus", value: "roomStatus" },
            { text: "rsvId", value: "rsvId" },
            { text: "rsvStatus", value: "rsvStatus" },
            { text: "payId", value: "payId" },
            { text: "payStatus", value: "payStatus" },
            { text: "memId", value: "memId" },
            { text: "mileage", value: "mileage" },
            { text: "memStatus", value: "memStatus" },
            { text: "prdId", value: "prdId" },
            { text: "ordId", value: "ordId" },
            { text: "qty", value: "qty" },
            { text: "ordStatus", value: "ordStatus" },
        ],
        roomview : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/roomviews')

      this.roomview = temp.data._embedded.roomviews;

    },
    methods: {
    }
  }
</script>

