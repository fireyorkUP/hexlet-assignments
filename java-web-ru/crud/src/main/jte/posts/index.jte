@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page


@template.layout.page(
    content = @`
            <main>
                <h1>Список постов</h1>
                <table class="table table-striped">
                    @for(var post : page.getPosts())
                        <tr>
                            <td>
                                ${post.getId()}
                            </td>
                            <td>
                                <a href="${exercise.util.NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                            </td>
                            <td>
                                ${post.getBody()}
                            </td>
                    </tr>
                    @endfor
                </table>>

                <div>
                 <a href="?page=${page.getPage() - 1}">Назад</a>
                 <a href="?page=${page.getPage() + 1}">Вперед</a>
                 </div>

            </main>
    `
)