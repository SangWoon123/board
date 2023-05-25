package org.tukorea.board.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tukorea.board.domain.Post;
import org.tukorea.board.persistence.PageRepository;
import org.tukorea.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	PageRepository pageRepository;
	
	@GetMapping("/board")
	public String showBoard(@RequestParam(defaultValue = "1") int page, Model model) throws Exception {
	    int pageSize = 5; // Number of posts per page
	    
	    int startIndex = (page - 1) * pageSize;
	    
	    
	    List<Post> posts = pageRepository.getPostsByPage(startIndex, pageSize);
	    model.addAttribute("posts", posts);   
	    
	    int totalPostsCount = pageRepository.getTotalPostsCount();
	    int totalPages = (int) Math.ceil((double) totalPostsCount / pageSize);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("currentPage", page);
	    
	    return "board/board";
	}

	
	@GetMapping("/board/{postId}")
    public String showPostOne(@PathVariable("postId") int postId, Model model) throws Exception {
		Post post=boardService.getByPostId(postId);
		model.addAttribute("post", post);
		return "board/post";
	}
	
	@GetMapping("/board/write")
    public String showWriteForm() {
        return "board/write";
    }
	
	@PostMapping("/board/write")
	public String writePost(@RequestParam("title") String title,
			@RequestParam("content") String content,
			HttpSession session) throws Exception {
		String username=(String) session.getAttribute("nickname");
		
		LocalDate current=LocalDate.now();
		
		Post post=new Post(title,content,username,current);
		boardService.createPost(post);

		
		
		return "redirect:/board";
	}
	
	@GetMapping("/board/{postId}/edit")
    public String showEditForm(@PathVariable("postId") int postId, 
    		HttpSession session,Model model) throws Exception {
		String uername=(String) session.getAttribute("nickname");

        Post post = boardService.getByPostId(postId);
        model.addAttribute("post", post);

        if (uername.equals(post.getAuthor())) {
        	return "board/authview";
        }else {
        	return "board/justview";
        	
        }
        
    }

    @PostMapping("/board/{postId}/edit")
    public String editPost(@PathVariable("postId") int postId,
                           @RequestParam("title") String title,
                           @RequestParam("content") String content) throws Exception {
        boardService.updatePost(postId, title, content);
        //System.out.println(postId+title+content);
        return "redirect:/board";
    }
    
    
    @GetMapping("/board/{postId}/delete")
    public String deletePost(@PathVariable("postId") int postId) throws Exception {
    	boardService.deletePost(postId);
    	return "redirect:/board";
    }
    
    @GetMapping("/board/search") // 검색
    public String searchPosts(@RequestParam("keyword")String keyword,Model model)throws Exception{
    	List<Post> searchs=boardService.searchPost(keyword);
    	model.addAttribute("search",searchs);
    	return "board/search";
    	
    }

}
