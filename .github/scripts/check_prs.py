import os
import requests
import json

def get_assigned_prs_not_reviewed_by_user(username, repo, token):
    """Fetch open PRs assigned to the user that are not reviewed by them."""
    prs_url = f"https://api.github.com/repos/{repo}/pulls?state=open"
    headers = {'Authorization': f'token {token}'}

    response = requests.get(prs_url, headers=headers)
    prs = response.json()

    for pr in prs:
        pr_number = pr['number']
        pr_title = pr['title']
        # Fetch the review requests for the PR
        review_requests_url = f"https://api.github.com/repos/{repo}/pulls/{pr_number}/requested_reviewers"
        review_requests_response = requests.get(review_requests_url, headers=headers)
        review_requests = review_requests_response.json()
        reviewers = [reviewer['login'] for reviewer in review_requests.get('users', [])]

        print('pr: ', pr_number, pr_title, reviewers)

        # Check if the user is a requested reviewer and has not reviewed the PR
        if username in reviewers:
            reviews_url = f"https://api.github.com/repos/{repo}/pulls/{pr_number}/reviews"
            reviews_response = requests.get(reviews_url, headers=headers)
            reviews = reviews_response.json()

            if not any(review['user']['login'] == username for review in reviews):
                print(f"Blocking merge due to unreviewed PR #{pr_number}: '{pr_title}' pending review by {username}.")
                exit(1)

if __name__ == "__main__":
    github_repo = os.environ['GITHUB_REPOSITORY']
    github_token = os.environ['GITHUB_TOKEN']
    pr_creator = os.environ['GITHUB_ACTOR']

    get_assigned_prs_not_reviewed_by_user(pr_creator, github_repo, github_token)
