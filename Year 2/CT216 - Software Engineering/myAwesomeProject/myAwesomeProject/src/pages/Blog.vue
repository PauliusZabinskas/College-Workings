<template>
  <h1>Welcome to my new Blog page</h1>
  <p>This is my very first blog entry</p>
  <div class="container">
    <div class="mb-3">
      <label for="exampleFormControlInput1" class="form-label">Email address</label>
      <input type="email" class="form-control" v-model="handle" id="exampleFormControlInput1" placeholder="name@example.com">
    </div>
    <div class="mb-3">
      <label for="exampleFormControlTextarea1" class="form-label">Comment</label>
      <textarea class="form-control" v-model="comment" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>
    <div class="mb-3 right">
      <button type="button" @click="postComment" class="btn btn-primary">Post Comment</button>
    </div>
    <div class="mb-3 right">
      <button type="button" @click="getComments" class="btn btn-primary">Show Comments</button>
    </div>
    <div v-if="commentsArray.length > 0">
    <li v-for="comment in commentsArray">
      <b>{{ comment.data.comment }}</b>
      <button type="button" @click="deleteComment(comment.id)" class="btn btn-primary">Delete Comment</button>
    </li>
  </div>
  </div>
</template>
<script>
import app from '../api/firebase';
import { getFunctions, httpsCallable } from "firebase/functions";
export default {
  data() {
    return {
      handle: '',
      comment: '',
      commentsArray:[]
    }
  },
  created(){

    this.getComments();
    //window.setInterval(this.getComments, 1000);
  },
  methods : {
    postComment() {
      const functions = getFunctions(app);
      const postComment = httpsCallable(functions, 'postcomment');
      postComment({"handle": this.handle, "comment": this.comment}).then((result) => {
        // Read result of the Cloud Function.
        // /** @type {any} */
        this.getComments();
      });
    },
    getComments() {
      let loader = this.$loading.show({    // Optional parameters
        loader: 'dots',
        container: this.$refs.container,
        canCancel: false
      });
      const functions = getFunctions(app);
      const getComments = httpsCallable(functions, 'getcomments');
      getComments().then((result) => {
        // Read result of the Cloud Function.
        // /** @type {any} */
        loader.hide();
        this.commentsArray = result.data;
      });
    },
    deleteComment(id){
      const functions = getFunctions(app);
      const deleteComment = httpsCallable(functions, 'deletecomment?id='+id);
      deleteComment().then((result) => {
        if(result.data == "Document successfully deleted")
          this.getComments();
      }); // To refresh the client
    }
  }
}
</script>
<style scoped>
.right{
  text-align: right;
}
</style>